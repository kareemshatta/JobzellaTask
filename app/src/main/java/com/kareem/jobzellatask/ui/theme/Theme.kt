package com.kareem.jobzellatask.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Primary,
    background = Gray1000
)

private val LightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Primary,
    background = Gray1000
)

@Composable
fun JobzellaTaskTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}