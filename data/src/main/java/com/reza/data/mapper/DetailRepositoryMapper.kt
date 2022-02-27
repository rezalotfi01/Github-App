package com.reza.data.mapper

import com.reza.data.model.UserDetailsRepoModel
import com.reza.domain.model.UserDetailsDomainModel
import org.mapstruct.Mapper

@Mapper
interface DetailRepositoryMapper {
    fun toDetailsDomainModel(model: UserDetailsRepoModel): UserDetailsDomainModel
}