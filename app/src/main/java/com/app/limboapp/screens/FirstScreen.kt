package com.app.limboapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R

@Preview
@Composable
fun FirstScreen(
    onLoginClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    val height = LocalConfiguration.current.screenHeightDp.dp
    Box(
        modifier = Modifier
            .background(BlackBackground)
            .paint(
                painter = painterResource(id = R.drawable.bg_fire),
                contentScale = ContentScale.Crop
            )
            .fillMaxSize()
    ) {
        LimboHeaderWithDesc(screenHeight = height)
        SignInOrUpButtons(
            onLoginClick = onLoginClick,
            onRegisterClick = onRegisterClick
        )
    }
}

@Composable
fun LimboHeaderWithDesc(screenHeight: Dp) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = screenHeight * 0.2f),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = TextWhite,
                        fontSize = 90.sp,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append("Limbo")
                }
                withStyle(
                    style = SpanStyle(
                        color = TextWhite,
                        fontSize = 18.sp,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(
                        "\nNauka programowania w C\n" +
                                "Aplikacja e-learningowa\n" +
                                "Politechniki Łódzkiej"
                    )
                }
            },
            textAlign = TextAlign.End,
            lineHeight = 20.sp
        )
    }
}

@Composable
fun SignInOrUpButtons(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {

    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Column(

        ) {

            GradientButton(
                text = "Zaloguj się",
                textColor = TextWhite,
                gradient = Brush.horizontalGradient(
                    colors = listOf(
                        DarkOrange,
                        MediumOrange,
                        LightOrange
                    )
                )
            ) {
                onLoginClick()
            }
            
            Spacer(modifier = Modifier.height(10.dp))

            GradientButton(
                modifier = Modifier
                    .padding(bottom = 50.dp),
                text = "Załóż konto",
                textColor = TextWhite,
                gradient = Brush.horizontalGradient(
                    colors = listOf(
                        ButtonBlack,
                        ButtonBlack
                    )
                ),
            ) {
                onRegisterClick()
            }

        }

    }
}

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textColor: Color,
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
