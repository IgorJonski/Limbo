package com.app.limboapp.ui

import android.graphics.Paint
import android.graphics.PathEffect
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.ui.theme.*

@Preview
@Composable
fun ChaptersScreen() {

}

@Composable
fun LimboLogoWithPointsAndProfile() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Flickers(flickers = 50)
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.limbo_flame),
                contentDescription = "Limbo Logo",
                modifier = Modifier
                    .size(48.dp)
            )
            Text(
                text = "Limbo",
                fontSize = 36.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                color = TextOrange,
                style = Typography.body1
            )
        }
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            CircleImage(
                imageID = R.drawable.profile_pic,
                contentDescription = "Profile",
                size = 40.dp,
                onClick = {

                }
            )
        }
    }
}

@Composable
fun Chapter(
    borderGradient: Brush,
    borderWidth: Dp,
    title: String,
    maxPoints: Int = 15,
    gainedPoints: Int,
    pointsColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = borderWidth,
                brush = borderGradient,
                shape = RoundedCornerShape(20.dp)
            )
            .background(BlackBackground)
            .padding(horizontal = 14.dp, vertical = 18.dp)
            .clickable { }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
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
                progressGradient = circleProgressGreenGradient
            )
        }
    }
}

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 35.dp,
    progressGradient: Brush = circleProgressOrangeGradient,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
    initValue: Float = 0f
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
                sweepAngle = 360f * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = (curPercentage.value * number).toInt().toString() + "%",
                color = TextWhite,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LimboTopBarPreview() {
    LimboLogoWithPointsAndProfile()
}


@Preview(showBackground = true)
@Composable
fun CircularProgressBarPreview() {
    CircularProgressBar(
        percentage = 0.8f,
        number = 100,
        initValue = 0.6f
    )
}
