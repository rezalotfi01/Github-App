package com.reza.remote.data

import com.reza.data.RemoteDataSource
import com.reza.data.model.UserDetailsRepoModel
import com.reza.data.model.UserSearchRepoModel
import com.reza.remote.ApiService
import com.reza.remote.mapper.DetailRemoteMapper
import com.reza.remote.mapper.SearchRemoteMapper
import kotlinx.coroutines.flow.*
import org.mapstruct.factory.Mappers
import java.lang.Exception


class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {

    override suspend fun searchUser(query: String, page: Int): Flow<UserSearchRepoModel> {
        val mapper = Mappers.getMapper(SearchRemoteMapper::class.java)

        return flow {
                val response = apiService.searchUser(query,page)
                if (response.errorMessage == null)
                    emit(mapper.toSearchRepositoryModels(response))
                else
                    throw Exception(response.errorMessage)
        }

    }

    override suspend fun getUserDetails(username: String): Flow<UserDetailsRepoModel> {
        val mappers = Mappers.getMapper(DetailRemoteMapper::class.java)

        return flow {
            val response = apiService.getUserDetails(username)
            emit(mappers.toDetailsRepositoryModels(response))
        }
    }
}
