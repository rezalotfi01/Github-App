package com.reza.domain.di

import com.reza.domain.usecase.GetUserDetailUseCase
import com.reza.domain.usecase.GetUserDetailUseCaseImpl
import com.reza.domain.usecase.SearchUserUseCase
import com.reza.domain.usecase.SearchUserUseCaseImpl
import org.koin.dsl.module


val domainModule = module {

    // Provide SearchUseCase
    single<SearchUserUseCase> {
        SearchUserUseCaseImpl(get())
    }

    // Provide DetailUseCase
    single<GetUserDetailUseCase> {
        GetUserDetailUseCaseImpl(get())
    }

}