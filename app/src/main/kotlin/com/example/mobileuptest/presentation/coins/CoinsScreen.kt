package com.example.mobileuptest.presentation.coins

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.subscribeAsState

@Composable
fun CoinsScreen(
    component: CoinsComponent,
    modifier: Modifier = Modifier
) {

    val state by component.state.subscribeAsState()

    CoinsView(state, modifier) { action ->
        component.doAction(action)
    }
}
