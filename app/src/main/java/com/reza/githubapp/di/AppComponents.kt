package com.reza.githubapp.di

import com.reza.data.di.repositoryModule
import com.reza.domain.di.domainModule
import com.reza.githubapp.di.modules.viewModelModule
import com.reza.remote.di.remoteModule

val appComponents = listOf(
    remoteModule,
    repositoryModule,
    domainModule,
    viewModelModule
)