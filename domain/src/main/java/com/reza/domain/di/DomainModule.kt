package com.reza.domain.di

import com.reza.domain.usercase.GetUserDetailUseCase
import com.reza.domain.usercase.GetUserDetailUseCaseImpl
import com.reza.domain.usercase.SearchUserUseCase
import com.reza.domain.usercase.SearchUserUseCaseImpl
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