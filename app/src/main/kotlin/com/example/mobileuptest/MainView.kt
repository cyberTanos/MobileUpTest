package com.example.mobileuptest

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.example.mobileuptest.RootComponent.RootScreen
import com.example.mobileuptest.presentation.coinInfo.CoinInfoScreen
import com.example.mobileuptest.presentation.coins.CoinsScreen
import com.example.mobileuptest.ui.theme.MUTheme
import com.example.mobileuptest.ui.theme.MobileUpTheme

@Composable
fun MainView(component: DefaultRootComponent) {

    MobileUpTheme {
        Surface(color = MUTheme.colors.background) {
            Children(
                stack = component.stack
            ) {
                when (val instance = it.instance) {
                    is RootScreen.Coins -> CoinsScreen(component = instance.component, Modifier)
                    is RootScreen.CoinInfo -> CoinInfoScreen(component = instance.component, Modifier)
                }
            }
        }
    }
}
