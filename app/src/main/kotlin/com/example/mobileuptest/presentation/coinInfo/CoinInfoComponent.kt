package com.example.mobileuptest.presentation.coinInfo

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import org.koin.core.component.KoinComponent

class DefaultCoinInfoComponent(
    componentContext: ComponentContext
) : CoinInfoComponent, KoinComponent, ComponentContext by componentContext {

    override val state = MutableValue(CoinInfoState())

    override fun doAction(action: CoinInfoAction) = Unit
}

interface CoinInfoComponent {
    val state: Value<CoinInfoState>
    fun doAction(action: CoinInfoAction)
}
