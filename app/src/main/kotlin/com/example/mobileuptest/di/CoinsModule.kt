package com.example.mobileuptest.di

import com.example.mobileuptest.data.RemoteCoinsDataSource
import com.example.mobileuptest.data.RepositoryImpl
import com.example.mobileuptest.domain.GetCoinsUseCase
import com.example.mobileuptest.domain.GetCoinsUseCaseImpl
import com.example.mobileuptest.domain.Repository
import org.koin.dsl.module

val coinsModule = module {
    single { RemoteCoinsDataSource(get()) }
    single<Repository> { RepositoryImpl(get()) }
    factory<GetCoinsUseCase> { GetCoinsUseCaseImpl(get()) }
}
