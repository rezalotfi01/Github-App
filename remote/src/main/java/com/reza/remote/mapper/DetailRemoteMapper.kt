package com.reza.remote.mapper

import com.reza.data.model.UserDetailsRepoModel
import com.reza.remote.model.UserDetailsResponse
import org.mapstruct.Mapper

@Mapper
interface DetailRemoteMapper {
    fun toDetailsRepositoryModels(model: UserDetailsResponse): UserDetailsRepoModel
}
