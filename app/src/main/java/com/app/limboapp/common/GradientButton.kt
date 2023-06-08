package com.app.limboapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textColor: Color = TextWhite,
    fontFamily: FontFamily = Montserrat,
    fontWeight: FontWeight = FontWeight.Bold,
    gradient: Brush,
    width: Float = 0.65f,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(25.dp),
        modifier = modifier,
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(width)
                .background(gradient)
                .padding(vertical = 18.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = textColor,
                fontFamily = fontFamily,
                fontWeight = fontWeight,
                letterSpacing = 1.sp
            )
        }
    }
}