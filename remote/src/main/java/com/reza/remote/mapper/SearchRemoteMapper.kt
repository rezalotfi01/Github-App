package com.reza.remote.mapper

import com.reza.data.model.UserSearchRepoModel
import com.reza.remote.model.UserSearchResponse
import org.mapstruct.Mapper

@Mapper
interface SearchRemoteMapper {
    fun toSearchRepositoryModels(model: UserSearchResponse): UserSearchRepoModel
}