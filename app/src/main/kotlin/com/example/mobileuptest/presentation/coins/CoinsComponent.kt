package com.example.mobileuptest.presentation.coins

import android.util.Log
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.mobileuptest.domain.GetCoinsUseCase
import com.example.mobileuptest.presentation.coins.CoinsAction.InitScreen
import com.example.mobileuptest.util.componentScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DefaultCoinsComponent(
    componentContext: ComponentContext
) : CoinsComponent, KoinComponent, ComponentContext by componentContext {

    private val getCoinsUseCase: GetCoinsUseCase by inject()

    override val state = MutableValue(CoinsState())

    override fun doAction(action: CoinsAction) {
        when (action) {
            is InitScreen -> fetchData(action.currency)
        }
    }

    private fun fetchData(currency: String) {
        componentScope.launch {
            runCatching {
                getCoinsUseCase(currency)
            }.onSuccess { response ->
                state.value = CoinsState(data = response, isLoading = false)
            }.onFailure { error ->
                Log.d("fetchData:", "$error")
            }
        }
    }
}

interface CoinsComponent {
    val state: Value<CoinsState>
    fun doAction(action: CoinsAction)
}
