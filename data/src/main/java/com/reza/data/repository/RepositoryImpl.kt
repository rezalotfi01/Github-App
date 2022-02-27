package com.reza.data.repository

import com.reza.data.RemoteDataSource
import com.reza.data.mapper.DetailRepositoryMapper
import com.reza.data.mapper.SearchRepositoryMapper
import com.reza.domain.Repository
import com.reza.domain.model.UserDetailsDomainModel
import com.reza.domain.model.UserSearchDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.mapstruct.factory.Mappers

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : Repository {

    override suspend fun searchUser(query: String, page: Int): Flow<UserSearchDomainModel> {
        val mapper = Mappers.getMapper(SearchRepositoryMapper::class.java)

        return remoteDataSource.searchUser(query,page)
            .map {
                mapper.toSearchDomainModel(it)
            }
    }

    override suspend fun getUserDetails(username: String): Flow<UserDetailsDomainModel> {
        val mapper = Mappers.getMapper(DetailRepositoryMapper::class.java)

        return remoteDataSource.getUserDetails(username)
            .map {
                mapper.toDetailsDomainModel(it)
            }
    }


}
