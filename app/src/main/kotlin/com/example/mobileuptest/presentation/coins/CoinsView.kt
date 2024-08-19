package com.example.mobileuptest.presentation.coins

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CoinsView(
    state: CoinsState,
    modifier: Modifier = Modifier,
    doAction: (CoinsAction) -> Unit
) {
    Text(text = state.toString())
}
