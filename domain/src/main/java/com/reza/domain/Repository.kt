package com.reza.domain

import com.reza.domain.model.*
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun searchUser(
        query: String, page: Int
    ): Flow<UserSearchDomainModel>

    suspend fun getUserDetails(
        username: String
    ): Flow<UserDetailsDomainModel>
}