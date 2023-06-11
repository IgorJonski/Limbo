package com.app.limboapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.common.CustomTextField
import com.app.limboapp.ui.theme.*

@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .background(BlackBackground)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LimboLogo(modifier = Modifier.padding(vertical = 14.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            RegisterSection()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AuthFooter(
                modifier = Modifier
                    .padding(bottom = 40.dp, top = 14.dp),
                onButtonClick = onRegisterClick,
                buttonText = "Zarejestruj się",
                staticPromptText = "Masz już konto? ",
                clickablePromptText = "Zaloguj się"
            )
        }
    }
}

@Composable
fun RegisterSection(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(true) }
    val passwordVisibilityIconId = if (passwordVisibility) {
        R.drawable.gradient_password_invisible
    } else R.drawable.gradient_password_visible
    var isStudent by remember { mutableStateOf(false) }
    var studentId by remember { mutableStateOf("") }

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Rejestracja",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(18.dp))
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTextField(
                value = email,
                hint = "Email",
                onValueChange = { email = it },
                trailingIconId = R.drawable.user_gradient_icon
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                value = name,
                hint = "Imię",
                onValueChange = { name = it }
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                value = surname,
                hint = "Nazwisko",
                onValueChange = { surname = it }
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                value = password,
                hint = "Hasło",
                onValueChange = { password = it },
                trailingIconId = passwordVisibilityIconId,
                onTrailingIconClick = { passwordVisibility = !passwordVisibility }
            )
            Spacer(modifier = Modifier.height(8.dp))
            CustomTextField(
                value = repeatPassword,
                hint = "Powtórz hasło",
                onValueChange = { repeatPassword = it }
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isStudent,
                    onCheckedChange = { isStudent = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = TextLightOrange,
                        uncheckedColor = Color.Gray
                    )
                )
                Text(
                    text = "Jesteś studentem PŁ?",
                    color = TextWhite,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clickable { isStudent = !isStudent }
                )
            }
            if (isStudent) {
                CustomTextField(
                    value = studentId,
                    hint = "Numer albumu",
                    onValueChange = { studentId = it }
                )
            }
        }
    }
}

// --------------------

@Preview()
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}

@Preview
@Composable
fun RegisterSectionPreview() {
    RegisterSection()
}

@Preview(widthDp = 300)
@Composable
fun RegisterFooterPreview() {
    AuthFooter(
        buttonText = "Zarejestruj się",
        staticPromptText = "Masz już konto? ",
        clickablePromptText = "Zaloguj się"
    )
}