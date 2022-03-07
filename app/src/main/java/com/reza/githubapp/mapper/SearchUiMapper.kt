package com.reza.githubapp.mapper

import com.reza.domain.model.ItemDomainModel
import com.reza.githubapp.model.SearchItemUiModel
import org.mapstruct.Mapper

@Mapper
interface SearchUiMapper {
    fun toItemUiModel(model: List<ItemDomainModel>): List<SearchItemUiModel>
}