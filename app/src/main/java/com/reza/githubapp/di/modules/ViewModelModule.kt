package com.reza.githubapp.di.modules

import com.reza.githubapp.ui.detail.DetailViewModel
import com.reza.githubapp.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    // Provide SearchViewModel
    viewModel {
        SearchViewModel(get())
    }

    // Provide DetailViewModel
    viewModel {
        DetailViewModel(get())
    }

}