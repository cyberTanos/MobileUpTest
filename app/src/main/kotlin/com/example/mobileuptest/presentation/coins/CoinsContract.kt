package com.example.mobileuptest.presentation.coins

import com.example.mobileuptest.domain.model.Coin

sealed interface CoinsAction {
    data class InitScreen(
        val currency: String = "usd"
    ) : CoinsAction
}

data class CoinsState(
    val data: List<Coin> = emptyList(),
    val isLoading: Boolean = true
)

sealed interface CoinsEffect
