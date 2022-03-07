package com.reza.githubapp.ui.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reza.domain.usecase.SearchUserUseCase
import com.reza.githubapp.mapper.SearchUiMapper
import com.reza.githubapp.model.SearchItemUiModel
import kotlinx.coroutines.flow.*
import org.mapstruct.factory.Mappers
import timber.log.Timber

class SearchPagingSource (
    private val searchUserUseCase: SearchUserUseCase,
    private val query: String
) : PagingSource<Int, SearchItemUiModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchItemUiModel> {
        val page = params.key ?: START_PAGE_INDEX
        Timber.e("page: $page and paramKey: ${params.key}")

        return try {
            val it = searchUserUseCase.execute(query,page).first()

            val nextKey = if (it.items.size < PAGE_SIZE)
                null
            else
                page + 1

            LoadResult.Page(
                data = Mappers.getMapper(SearchUiMapper::class.java).toItemUiModel(it.items),
                prevKey = null,
                nextKey = nextKey
            )
        }catch (t: Throwable){
            LoadResult.Error<Int, SearchItemUiModel>(t)
        }
    }


    /** The refresh key is used for the initial load of the next PagingSource, after invalidation
     * We need to get the previous key (or next key if previous is null) of the page
     * that was closest to the most recently accessed index.
     * Anchor position is the most recently accessed index
     */
    override fun getRefreshKey(state: PagingState<Int, SearchItemUiModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object{
        private const val START_PAGE_INDEX = 1
        const val PAGE_SIZE = 30
    }
}