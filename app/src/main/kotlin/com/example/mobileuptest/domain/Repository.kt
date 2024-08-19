package com.example.mobileuptest.domain

import com.example.mobileuptest.domain.model.Coin

interface Repository {
    suspend fun getCoins(currency: String): List<Coin>
}
