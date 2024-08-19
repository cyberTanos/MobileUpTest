package com.example.mobileuptest.presentation.coins

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import org.koin.core.component.KoinComponent

class DefaultCoinsComponent(
    componentContext: ComponentContext
): CoinsComponent, KoinComponent, ComponentContext by componentContext {

    override val state = MutableValue(CoinsState())

    override fun doAction(action: CoinsAction) = Unit
}

interface CoinsComponent {
    val state: Value<CoinsState>
    fun doAction(action: CoinsAction)
}
