package com.example.mobileuptest.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun MobileUpTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalMUColors provides themePalette,
        LocalMUTypography provides typography,
        content = content
    )
}

object MUTheme {
    internal val colors: MUColors
        @Composable get() = LocalMUColors.current

    internal val typography: MUTypography
        @Composable get() = LocalMUTypography.current
}

internal val LocalMUColors = staticCompositionLocalOf<MUColors> { error("No colors provided") }
internal val LocalMUTypography = staticCompositionLocalOf<MUTypography> { error("No font provided") }
