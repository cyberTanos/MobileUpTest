package com.example.mobileuptest.presentation.coinInfo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState

@Composable
fun CoinInfoScreen(
    component: CoinInfoComponent,
    modifier: Modifier = Modifier
) {

    val state by component.state.subscribeAsState()

    CoinInfoView(state, modifier) { action ->
        component.doAction(action)
    }
}
