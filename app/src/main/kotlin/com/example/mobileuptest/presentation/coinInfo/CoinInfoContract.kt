package com.example.mobileuptest.presentation.coinInfo

sealed interface CoinInfoAction

data class CoinInfoState(
    val isLoading: Boolean = true
)

sealed interface CoinInfoEffect
