package com.app.limboapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.ui.theme.BlackBackground
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite
import com.app.limboapp.ui.theme.horizontalBlackGradient
import com.app.limboapp.ui.theme.orangeGradient

@Composable
fun StatsScreen(modifier: Modifier = Modifier) {
    StatsScreenContent(modifier = modifier.background(BlackBackground))
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

@Composable
fun StatsSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        StatsRow(text = "Wykonanych pytań", value = "25")
        StatsRow(text = "Ukończonych działów", value = "1")
        StatsRow(text = "Średni czas na pytanie", value = "5,5s")
        StatsRow(text = "Najwięcej pytań w ciągu dnia", value = "15")
    }
}

@Composable
fun GainedBonusCard(
    modifier: Modifier = Modifier,
    borderGradient: Brush = orangeGradient,
    text: String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .background(horizontalBlackGradient)
            .border(
                width = 1.dp,
                brush = borderGradient,
                shape = RoundedCornerShape(25.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "+21",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .padding(bottom = 14.dp)
                .padding(horizontal = 20.dp),
            text = text,
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GainedBonusRow(modifier: Modifier = Modifier) {

    val localDensity = LocalDensity.current

    var tallestColumnHeightDp by remember { mutableStateOf(10.dp) }

    // TODO ask if it isn't a  infinite recomposition (could I use height on Row?)

    Row(
        modifier = modifier
            .onGloballyPositioned { coordinates ->
                tallestColumnHeightDp = with(localDensity) {
                    coordinates.size.height.toDp()
                }
            },
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        GainedBonusCard(
            modifier = Modifier
                .weight(1f),
            text = "Dodatkowe punkty na egzaminie"
        )
        GainedBonusCard(
            modifier = Modifier
                .weight(1f)
                .height(tallestColumnHeightDp),
            text = "Short xD"
        )
    }
}

@Composable
fun GainedBonusSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Otrzymane bonusy",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        GainedBonusRow()
    }
}

@Composable
fun StatsScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = "Statystyki",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        StatsSection()
        Spacer(modifier = Modifier.height(26.dp))
        GainedBonusSection()
    }
}

@Preview
@Composable
fun StatsRowPreview() {
    StatsRow(
        text = "Wykonanych pytań",
        value = "20"
    )
}

@Preview
@Composable
fun StatsSectionPreview() {
    StatsSection()
}

@Preview
@Composable
fun GainedBonusCardPreview() {
    GainedBonusCard(text = "Dodatkowe punkty na egzaminie")
}

@Preview(widthDp = 300)
@Composable
fun GainedBonusRowPreview() {
    GainedBonusRow()
}

@Preview
@Composable
fun GainedBonusSectionPreview() {
    GainedBonusSection()
}

@Preview
@Composable
fun StatsScreenContentPreview() {
    StatsScreenContent()
}

@Preview
@Composable
fun StatsScreenPreview() {
    StatsScreen()
}