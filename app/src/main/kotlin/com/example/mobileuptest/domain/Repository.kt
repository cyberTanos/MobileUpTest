package com.example.mobileuptest.domain

interface Repository {
    suspend fun getCoins(): List<String>
}
