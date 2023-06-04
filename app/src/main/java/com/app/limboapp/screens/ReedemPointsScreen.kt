package com.app.limboapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite

@Composable
fun RedeemPointsScreen() {

}

@Composable
fun GainedFlickersBadge(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(92.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.flickers_img),
            contentDescription = "Gained flickers"
        )
        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = 10.dp),
            text = "49",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 48.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun GainedFlickersSection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Twoje dostępne punkty",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.width(16.dp))
        GainedFlickersBadge()
    }
}

// --------------------

@Preview
@Composable
fun RedeemPointsScreenPreview() {
    RedeemPointsScreen()
}

@Preview
@Composable
fun GainedFlickersBadgePreview() {
    GainedFlickersBadge()
}

@Preview
@Composable
fun GainedFlickersSectionPreview() {
    GainedFlickersSection()
}