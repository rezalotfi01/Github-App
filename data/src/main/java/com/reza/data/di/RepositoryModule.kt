package com.reza.data.di

import com.reza.data.repository.RepositoryImpl
import com.reza.domain.Repository
import org.koin.dsl.module

val repositoryModule = module {

    // Provide Repository
    single <Repository> {
        RepositoryImpl(get())
    }


}