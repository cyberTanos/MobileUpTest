package com.example.mobileuptest.data

import com.example.mobileuptest.data.response.CoinResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

class RemoteCoinsDataSource(
    private val httpClient: HttpClient
) {

    suspend fun getCoins(currency: String): List<CoinResponse> {
        return httpClient.get {
            url("coins/markets")
            parameter("vs_currency", currency)
        }.body()
    }
}
