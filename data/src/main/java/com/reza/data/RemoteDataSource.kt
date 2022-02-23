package com.reza.data


import com.reza.data.model.UserDetailsRepoModel
import com.reza.data.model.UserSearchRepoModel
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun searchUser(
         query: String, page: Int
    ): Flow<UserSearchRepoModel>

    suspend fun getUserDetails(
        username: String
    ): Flow<UserDetailsRepoModel>

}