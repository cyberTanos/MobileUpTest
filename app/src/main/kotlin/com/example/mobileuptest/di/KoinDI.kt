package com.example.mobileuptest.di

import org.koin.core.context.startKoin

object KoinDI {

    fun init() {
        startKoin {
            modules(
                ktorModule,
                coinsModule
            )
        }
    }
}
