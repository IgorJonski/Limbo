package com.app.limboapp.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.model.ChapterData
import com.app.limboapp.ui.theme.*

@Preview
@Composable
fun ChaptersScreen() {
    ChaptersSection(modifier = Modifier.background(BlackBackground))
}

@Composable
fun ChaptersSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Rozdziały",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 16.dp, start = 20.dp)
        )
        ChaptersList()
    }
}

@Composable
fun ChaptersList(
    modifier: Modifier = Modifier
) {
    val data = getFakeChaptersData()
    LazyColumn(modifier = modifier) {
        items(data) { item ->
            Chapter(
                title = item.title,
                gainedPoints = item.gainedPoints,
                isUnlocked = item.isUnlocked,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 14.dp)
            )
        }
    }
}

@Composable
fun Chapter(
    modifier: Modifier = Modifier,
    borderWidth: Dp = 1.dp,
    title: String,
    maxPoints: Int = 15,
    gainedPoints: Int,
    isUnlocked: Boolean = false
) {
    val isCompleted = gainedPoints == maxPoints

    val borderGradient = if (!isUnlocked) {
        redGradient
    } else if (isCompleted) {
        greenGradient
    } else orangeGradient

    val pointsColor = if (!isUnlocked || !isCompleted) {
        LightOrange
    } else LightGreen

    val progressColor = if (isCompleted) {
        circleProgressGreenGradient
    } else circleProgressOrangeGradient

    Row(
        modifier = modifier
            .alpha(
                if (isUnlocked) 1f else 0.5f
            )
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = borderWidth,
                brush = borderGradient,
                shape = RoundedCornerShape(20.dp)
            )
            .background(BlackBackground)
            .padding(horizontal = 14.dp, vertical = 18.dp)
            .clickable { },
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                color = TextWhite,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Text(
                text = "Zdobyte punkty",
                color = TextWhite,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(bottom = 6.dp)
            )
            Text(
                text = "$gainedPoints/$maxPoints",
                color = pointsColor,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
        CircularProgressBar(
            modifier = Modifier.weight(1f),
            percentage = (gainedPoints / maxPoints.toFloat()),
            number = 100,
            progressGradient = progressColor
        )
    }
}

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    number: Int = 100,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 35.dp,
    progressGradient: Brush = circleProgressOrangeGradient,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
    initValue: Float = 0f,
    isUnlocked: Boolean = true
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else initValue,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(radius * 2f + strokeWidth)
    ) {
        Canvas(
            modifier = Modifier
                .size(radius * 2f)
        ) {
            drawCircle(
                color = CircleGray
            )
            drawArc(
                brush = progressGradient,
                startAngle = -90f,
                sweepAngle = if (isUnlocked) 360f * curPercentage.value else 360f,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val percentageTextSize = 18.sp * (radius / 35.dp)
            Text(
                text = (curPercentage.value * number).toInt().toString() + "%",
                color = TextWhite,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = percentageTextSize
            )
        }
    }
}

// --------------------

@Preview(showBackground = true)
@Composable
fun CircularProgressBarPreview() {
    CircularProgressBar(
        percentage = 0.8f,
        number = 100,
        initValue = 0.6f
    )
}

@Preview
@Composable
fun ChapterPreview() {
    Chapter(
        borderWidth = 2.dp,
        title = "Operacje na danych",
        gainedPoints = 15,
        isUnlocked = true
    )
}

@Preview
@Composable
fun ChaptersPreview() {
    ChaptersList()
}

fun getFakeChaptersData(): List<ChapterData> {
    return listOf(
        ChapterData("Operacje na danych", 15, 15, true),
        ChapterData("Instrukcje warunkowe", 7, 15, true),
        ChapterData("Pętle, instrukcje iteracyjne", 0, 15),
        ChapterData("Pętle, instrukcje iteracyjne", 0, 15),
        ChapterData("Pętle, instrukcje iteracyjne", 0, 15),
        ChapterData("Pętle, instrukcje iteracyjne", 0, 15),
        ChapterData("Pętle, instrukcje iteracyjne", 0, 15),
    )
}
