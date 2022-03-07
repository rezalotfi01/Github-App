package com.reza.githubapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reza.domain.usecase.GetUserDetailUseCase
import com.reza.githubapp.mapper.DetailUiMapper
import com.reza.githubapp.model.UserDetailsUiModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.mapstruct.factory.Mappers

class DetailViewModel(
    private val getUserDetailUseCase: GetUserDetailUseCase
) : ViewModel() {

    private val _userDetailFlow = MutableStateFlow<UserDetailsUiModel?>(null)
    val userDetailFlow get() = _userDetailFlow.asStateFlow()

    private val _errorFlow = MutableStateFlow<Throwable?>(null)
    val errorFlow get() = _errorFlow.asStateFlow()

    fun getUserDetail(username: String){
        viewModelScope.launch {
            val mapper = Mappers.getMapper(DetailUiMapper::class.java)
            getUserDetailUseCase.execute(username)
                .onEach {
                    _userDetailFlow.value = mapper.toDetailUiModel(it)
                }
                .catch { cause: Throwable ->
                    _errorFlow.value = cause
                }
                .distinctUntilChanged()
                .collect()
        }
    }

}