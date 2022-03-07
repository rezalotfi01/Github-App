package com.reza.githubapp.mapper

import com.reza.domain.model.UserDetailsDomainModel
import com.reza.githubapp.model.UserDetailsUiModel
import org.mapstruct.Mapper

@Mapper
interface DetailUiMapper {
    fun toDetailUiModel(model: UserDetailsDomainModel): UserDetailsUiModel

}