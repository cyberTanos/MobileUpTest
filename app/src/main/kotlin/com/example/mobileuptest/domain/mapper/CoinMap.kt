package com.example.mobileuptest.domain.mapper

import com.example.mobileuptest.data.response.CoinResponse
import com.example.mobileuptest.domain.model.Coin
import com.example.mobileuptest.domain.model.Coin.Value
import com.example.mobileuptest.util.orZero

fun List<CoinResponse>.toDomain(): List<Coin> {
    return this.map {
        Coin(
            id = it.id.orEmpty(),
            symbol = it.symbol.orEmpty(),
            name = it.name.orEmpty(),
            image = it.image.orEmpty(),
            price = it.price.orZero(),
            priceChangePercentage = getValuePercentage(it.priceChangePercentage.orZero())
        )
    }
}

private fun getValuePercentage(value: Float): Value {
    val price = if (value > 0) "+$value%" else "-$value%"
    return Value(
        value = price,
        positive = value > 0
    )
}
