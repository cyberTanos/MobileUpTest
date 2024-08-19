package com.example.mobileuptest

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.value.Value
import com.example.mobileuptest.RootComponent.RootScreen
import com.example.mobileuptest.presentation.coinInfo.CoinInfoComponent
import com.example.mobileuptest.presentation.coinInfo.DefaultCoinInfoComponent
import com.example.mobileuptest.presentation.coins.CoinsComponent
import com.example.mobileuptest.presentation.coins.DefaultCoinsComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootScreenConfig>()

    override val stack: Value<ChildStack<*, RootScreen>> =
        childStack(
            source = navigation,
            serializer = RootScreenConfig.serializer(),
            initialConfiguration = RootScreenConfig.CoinsConfig,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: RootScreenConfig, componentContext: ComponentContext): RootScreen {
       return when(config) {
            is RootScreenConfig.CoinsConfig -> RootScreen.Coins(DefaultCoinsComponent(componentContext))
            is RootScreenConfig.CoinInfoConfig -> RootScreen.CoinInfo(DefaultCoinInfoComponent(componentContext))
        }
    }

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    @Serializable
    sealed interface RootScreenConfig {

        @Serializable
        data object CoinsConfig : RootScreenConfig

        @Serializable
        data class CoinInfoConfig(
            val data: String
        ) : RootScreenConfig
    }
}

interface RootComponent {

    val stack: Value<ChildStack<*, RootScreen>>

    fun onBackClicked(toIndex: Int)

    @Serializable
    sealed class RootScreen {

        @Serializable
        class Coins(val component: CoinsComponent) : RootScreen()

        @Serializable
        class CoinInfo(val component: CoinInfoComponent) : RootScreen()
    }
}
