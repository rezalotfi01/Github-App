package com.reza.githubapp.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.reza.domain.usecase.SearchUserUseCase
import com.reza.githubapp.model.SearchItemUiModel
import com.reza.githubapp.ui.search.paging.SearchPagingSource
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*

class SearchViewModel(
    private val searchUserUseCase: SearchUserUseCase
) : ViewModel() {

    private val _usersDataFlow = MutableStateFlow<PagingData<SearchItemUiModel>?>(null)
    val usersDataFlow get() = _usersDataFlow.asStateFlow()

    private val _errorFlow = MutableStateFlow<Throwable?>(null)
    val errorFlow get() = _errorFlow.asStateFlow()

    private var latestPagingDataJob: Job? = null

    /**
     * Paging and Pager implemented here because the inner layers (i.e. Domain layer) should be
     * pure kotlin and we should use Android Framework tools in the outer layers (Presentation layer)
     */
    fun searchUser(query: String){
        latestPagingDataJob?.cancel()
        latestPagingDataJob =
            Pager(
                config = PagingConfig(
                    pageSize = SearchPagingSource.PAGE_SIZE,
                    initialLoadSize = SearchPagingSource.PAGE_SIZE,
                    enablePlaceholders = false
                ),
                pagingSourceFactory = {
                    SearchPagingSource(
                        searchUserUseCase,
                        query
                    )
                }
            ).flow
                .cachedIn(viewModelScope)
                .onEach {
                    _usersDataFlow.value = it
                }
                .catch { cause: Throwable ->
                    _errorFlow.value = cause
                }
                .distinctUntilChanged()
                .launchIn(viewModelScope)
    }



}