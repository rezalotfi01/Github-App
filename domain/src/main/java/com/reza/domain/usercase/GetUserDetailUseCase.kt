package com.reza.domain.usercase

import com.reza.domain.Repository
import com.reza.domain.model.UserDetailsDomainModel
import kotlinx.coroutines.flow.Flow

interface GetUserDetailUseCase {
    suspend fun execute(username: String): Flow<UserDetailsDomainModel>
}

class GetUserDetailUseCaseImpl(
    private val repository: Repository
) : GetUserDetailUseCase{
    override suspend fun execute(
        username: String
    ): Flow<UserDetailsDomainModel> {
        return repository.getUserDetails(username)
    }
}