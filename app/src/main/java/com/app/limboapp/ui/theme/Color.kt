package com.app.limboapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val BlackBackground = Color(0xFF0D0D0D)
val TextWhite = Color(0xFFEEEEFF)
val DarkOrange = Color(0xFFF92100)
val MediumOrange = Color(0xFFFA5F00)
val LightOrange = Color(0xFFFCa401)
val ButtonBlack = Color(0xFF0D0D0D)
val TextOrange = Color(0xFFEC5500)
val TextLightOrange = Color(0xFFFB6801)
val DarkGray = Color(0xFF181818)
val CircleGray = Color(0xFF1E1E1E)
val LightGreen = Color(0xFF3FB105)
val DarkGreen = Color(0xFF12350A)

val horizontalOrangeGradient = Brush.horizontalGradient(
    colors = listOf(
        DarkOrange,
        MediumOrange,
        LightOrange
    )
)

val greenGradient = Brush.horizontalGradient(
    colors = listOf(
        LightGreen,
        DarkGreen
    )
)

val circleProgressGreenGradient = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFF00F90A),
        Color(0xFF1F7600)
    )
)

val circleProgressOrangeGradient = Brush.horizontalGradient(
    colors = listOf(
        Color(0xFFFDBB00),
        Color(0xFFF90800)
    )
)

val horizontalBlackGradient = Brush.horizontalGradient(
    colors = listOf(
        BlackBackground,
        Color(0xFF121212),
        Color(0xFF151515),
        Color(0xFF141414),
        Color(0xFF111111)
    )
)