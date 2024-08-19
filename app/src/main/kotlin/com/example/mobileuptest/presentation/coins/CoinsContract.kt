package com.example.mobileuptest.presentation.coins

sealed interface CoinsAction

data class CoinsState(
    val isLoading: Boolean = true
)

sealed interface CoinsEffect
