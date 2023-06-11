package com.app.limboapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.common.CustomTextField
import com.app.limboapp.common.GradientButton
import com.app.limboapp.ui.theme.*

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .background(BlackBackground)
            .fillMaxSize()
    ) {
        LimboLogo(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(vertical = 14.dp)
        )
        LoginSection(
            modifier = Modifier
                .align(Alignment.Center)
        )
        AuthFooter(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            onButtonClick = onLoginClick,
            buttonText = "Zaloguj się",
            staticPromptText = "Nie masz konta? ",
            clickablePromptText = "Zarejestruj się"
        )
    }
}

// --------------------

@Composable
fun LimboLogo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = R.drawable.limbo_flame),
            contentDescription = null
        )
        Text(
            text = "Limbo",
            fontSize = 36.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            color = TextOrange
        )
    }
}

@Composable
fun LoginSection(
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val passwordVisibilityIconId = if (passwordVisibility) {
        R.drawable.gradient_password_invisible
    } else R.drawable.gradient_password_visible

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Logowanie",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(26.dp))
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            hint = "Email użytkownika",
            trailingIconId = R.drawable.user_gradient_icon,
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            hint = "Hasło",
            trailingIconId = passwordVisibilityIconId,
            onTrailingIconClick = { passwordVisibility = !passwordVisibility }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Zapomniałeś hasła?",
            color = TextLightOrange,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.End)
                .clickable { }
        )
    }
}

@Composable
fun AuthFooter(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit = {},
    buttonText: String,
    staticPromptText: String,
    clickablePromptText: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        GradientButton(
            gradient = orangeGradient,
            text = buttonText,
            onClick = onButtonClick
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = staticPromptText,
                color = TextWhite,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp
            )
            Text(
                text = clickablePromptText,
                color = TextLightOrange,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.clickable {  }
            )
        }
    }
}

// --------------------

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

@Preview
@Composable
fun LimboLogoPreview() {
    LimboLogo()
}

@Preview
@Composable
fun LoginSectionPreview() {
    LoginSection()
}

@Preview(widthDp = 300)
@Composable
fun LoginFooterPreview() {
    AuthFooter(
        buttonText = "Zaloguj się",
        staticPromptText = "Nie masz konta? ",
        clickablePromptText = "Zarejestruj się"
    )
}