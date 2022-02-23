package com.reza.remote.data

import com.reza.data.RemoteDataSource
import com.reza.data.model.UserDetailsRepoModel
import com.reza.data.model.UserSearchRepoModel
import com.reza.remote.ApiService
import com.reza.remote.mapper.DetailRemoteMapper
import com.reza.remote.mapper.SearchRemoteMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mapstruct.factory.Mappers


class RemoteDataSourceImpl(private val apiService: ApiService) : RemoteDataSource {

    override suspend fun searchUser(query: String, page: Int): Flow<UserSearchRepoModel> {
        val mapper = Mappers.getMapper(SearchRemoteMapper::class.java)

        return apiService.searchUser(query,page).map {
            mapper.toSearchRepositoryModels(it)
        }
    }

    override suspend fun getUserDetails(username: String): Flow<UserDetailsRepoModel> {
        val mappers = Mappers.getMapper(DetailRemoteMapper::class.java)

        return apiService.getUserDetails(username).map {
            mappers.toDetailsRepositoryModels(it)
        }
    }
}
