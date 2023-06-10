package com.app.limboapp.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.common.CustomTextField
import com.app.limboapp.ui.theme.*

@Preview(showBackground = true)
@Composable
fun RegisterScreen(
    onRegisterClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LimboLogoToFix()
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            RegisterTextFields()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AuthFooter(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp),
                onButtonClick = onRegisterClick,
                buttonText = "Zaloguj się",
                staticPromptText = "Nie masz konta?",
                clickablePromptText = "Zarejestruj się"
            )
        }
    }
}

@Composable
fun RegisterTextFields() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        ) {
        Text(
            text = "Rejestracja",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(26.dp))

        var email by rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .width(300.dp),
            value = email,
            onValueChange = {
                email = it
            },
            shape = RoundedCornerShape(20.dp),
            placeholder = {
                Text(
                    text = "Email użytkownika",
                    color = TextWhite,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Light,
                    fontSize = 15.sp
                )
            },
            textStyle = TextStyle(
                color = TextWhite
            ),
            trailingIcon = {
                IconButton(onClick = {

                }) {
                    Image(
                        painter = painterResource(id = R.drawable.user_gradient_icon),
                        contentDescription = "Email użytkownika",
                        modifier = Modifier
                            .padding(12.dp)
                            .size(30.dp)
                    )
                }
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Default
            ),
            keyboardActions = KeyboardActions(
                onAny = {
                    Log.d("LOG_TAG", "Clicked email done")
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                textColor = TextWhite,
                disabledTextColor = TextWhite,
                backgroundColor = DarkGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(10.dp))
        var name by remember { mutableStateOf("") }
        CustomTextField(
            value = name,
            onValueChange = { name = it },
            hint = "Imię",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onTrailingIconClick = {}
        ) {
            Log.d("LOG_TAG", "Finished $name")
        }

        Spacer(modifier = Modifier.height(10.dp))
        var surname by remember { mutableStateOf("") }
        CustomTextField(
            value = surname,
            onValueChange = { surname = it },
            hint = "Nazwisko",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onTrailingIconClick = {}
        ) {
            Log.d("LOG_TAG", "Finished $surname")
        }

        Spacer(modifier = Modifier.height(10.dp))
        var password by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        CustomTextField(
            value = password,
            onValueChange = { password = it },
            hint = "Hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            trailingIconId = if (passwordVisibility) {
                R.drawable.gradient_password_invisible
            } else R.drawable.gradient_password_visible,
            onTrailingIconClick = { passwordVisibility = !passwordVisibility },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else PasswordVisualTransformation()
        ) {
            Log.d("LOG_TAG", "Finished $password")
        }

        Spacer(modifier = Modifier.height(10.dp))
        var repeatPassword by remember { mutableStateOf("") }
        CustomTextField(
            value = repeatPassword,
            onValueChange = { repeatPassword = it },
            hint = "Powtórz hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ) {
            Log.d("LOG_TAG", "Finished $repeatPassword")
        }

        Spacer(modifier = Modifier.height(10.dp))
        var isStudent by remember { mutableStateOf(false) }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Checkbox(
                checked = isStudent,
                onCheckedChange = {
                    isStudent = it
                },
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
        
        Spacer(modifier = Modifier.height(10.dp))
        var studentID by remember { mutableStateOf("") }
        if (isStudent) {
            CustomTextField(
                value = studentID,
                onValueChange = { studentID = it },
                hint = "Numer albumu",
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                enabled = isStudent
            ) {
                Log.d("LOG_TAG", "Finished $studentID")
            }
        }
    }
}

@Composable
fun LimboLogoToFix() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
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
            color = TextOrange
        )
    }
}