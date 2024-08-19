package com.example.mobileuptest.domain.model

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val price: Float,
    val priceChangePercentage: Value
) {

    class Value(
        val value: String,
        val positive: Boolean
    )
}
