package com.example.mobileuptest.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinResponse(
    @SerialName("id") val id: String?,
    @SerialName("symbol") val symbol: String?,
    @SerialName("name") val name: String?,
    @SerialName("image") val image: String?,
    @SerialName("current_price") val price: Float?,
    @SerialName("price_change_percentage_24h") val priceChangePercentage: Float?
)
