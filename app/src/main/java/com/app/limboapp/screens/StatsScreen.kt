package com.app.limboapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.ui.theme.BlackBackground
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite
import com.app.limboapp.ui.theme.orangeGradient

@Composable
fun StatsScreen() {

}

@Composable
fun StatsRow(
    modifier: Modifier = Modifier,
    borderGradient: Brush = orangeGradient,
    text: String,
    value: String
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .border(
                width = 1.dp,
                brush = borderGradient,
                shape = RoundedCornerShape(25.dp)
            )
            .background(BlackBackground),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(start = 30.dp)
                .padding(vertical = 16.dp),
            text = text,
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(end = 30.dp),
            text = value,
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

//-----------------------------------------

@Preview
@Composable
fun StatsRowPreview() {
    StatsRow(
        text = "Wykonanych pytań",
        value = "20"
    )
}