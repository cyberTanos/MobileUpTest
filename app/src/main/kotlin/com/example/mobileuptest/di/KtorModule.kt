package com.example.mobileuptest.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

private const val BASE_URL = "https://api.coingecko.com/api/v3/"
private const val TOKEN = "GDVBgpky1gW42iSKRZEmCNDX"

val ktorModule = module {
    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }

            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.ALL
            }

            defaultRequest {
                header("Content-Type", "application/json; charset=UTF-8")
                header("x-cg-api-key", TOKEN)
                url(BASE_URL)
            }
        }
    }
}
