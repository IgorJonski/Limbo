package com.app.limboapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.common.GradientButton
import com.app.limboapp.ui.theme.BlackBackground
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite
import com.app.limboapp.ui.theme.horizontalBlackGradient
import com.app.limboapp.ui.theme.orangeGradient

@Preview
@Composable
fun FirstScreen(
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    Box(
        modifier = Modifier
            .background(BlackBackground)
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_fire),
                contentScale = ContentScale.Crop
            )
    ) {
        LimboHeader(
            modifier = Modifier
                .padding(top = screenHeight * 0.2f)
                .align(Alignment.TopCenter)
        )
        LoginButtonsSection(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .align(Alignment.BottomCenter),
            onLoginClick = onLoginClick,
            onRegisterClick = onRegisterClick
        )
    }
}

@Composable
fun LimboTitle() {
    Text(
        text = "Limbo",
        color = TextWhite,
        fontSize = 90.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun LimboDescription(modifier: Modifier = Modifier) {
    Text(
        text = "Nauka programowania w C\n" +
                "Aplikacja e-learningowa\n" +
                "Politechniki Łódzkiej",
        color = TextWhite,
        fontSize = 18.sp,
        fontFamily = Montserrat,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.End,
        modifier = modifier
    )
}

@Composable
fun LimboHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.End
    ) {
        LimboTitle()
        LimboDescription(modifier = Modifier.offset(y = (-16).dp))
    }
}

@Composable
fun LoginButtonsSection(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        GradientButton(
            text = "Zaloguj się",
            gradient = orangeGradient,
            onClick = onLoginClick
        )
        Spacer(modifier = Modifier.height(10.dp))
        GradientButton(
            text = "Załóż konto",
            gradient = horizontalBlackGradient,
            onClick = onRegisterClick
        )
    }
}

// --------------------

@Preview
@Composable
fun LimboTitlePreview() {
    LimboTitle()
}

@Preview
@Composable
fun LimboDescriptionPreview() {
    LimboDescription()
}

@Preview
@Composable
fun LimboHeaderPreview() {
    LimboHeader()
}

@Preview
@Composable
fun LoginButtonsSectionPreview() {
    LoginButtonsSection(modifier = Modifier.fillMaxWidth())
}