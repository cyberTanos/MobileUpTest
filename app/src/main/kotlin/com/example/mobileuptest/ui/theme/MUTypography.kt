package com.example.mobileuptest.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val typography = MUTypography(
    toolbar = TextStyle(
        color = themePalette.backgroundOn,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center
    ),
    title = TextStyle(
        color = themePalette.backgroundOn,
        fontSize = 12.sp,
        textAlign = TextAlign.Center
    ),
    body = TextStyle(
        color = themePalette.backgroundOn,
        fontSize = 16.sp,
        textAlign = TextAlign.Center
    )
)
