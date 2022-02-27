package com.reza.domain.usercase

import com.reza.domain.Repository
import com.reza.domain.model.UserSearchDomainModel
import kotlinx.coroutines.flow.Flow

interface SearchUserUseCase {
    suspend fun execute(query: String, page: Int): Flow<UserSearchDomainModel>
}

class SearchUserUseCaseImpl(
    private val repository: Repository
) : SearchUserUseCase {
    override suspend fun execute(
        query: String,
        page: Int
    ): Flow<UserSearchDomainModel> {
        return repository.searchUser(query, page)
    }
}