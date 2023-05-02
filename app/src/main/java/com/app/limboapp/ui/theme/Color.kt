package com.app.limboapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val BlackBackground = Color(0xA0000000)
val TextWhite = Color(0xFFEEEEFF)
val DarkOrange = Color(0xFFF92100)
val MediumOrange = Color(0xFFFA5F00)
val LightOrange = Color(0xFFFCa401)
val ButtonBlack = Color(0xFF0D0D0D)
val TextOrange = Color(0xFFEC5500)
val TextLightOrange = Color(0xFFFB6801)
val DarkGray = Color(0xFF252525)

val horizontalOrangeGradient = Brush.horizontalGradient(
    colors = listOf(
        DarkOrange,
        MediumOrange,
        LightOrange
    )
)