package com.reza.data.mapper

import com.reza.data.model.UserSearchRepoModel
import com.reza.domain.model.UserSearchDomainModel
import org.mapstruct.Mapper


@Mapper
interface SearchRepositoryMapper {
    fun toSearchDomainModel(model: UserSearchRepoModel): UserSearchDomainModel
}