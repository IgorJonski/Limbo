package com.app.limboapp.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
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
import com.app.limboapp.ui.theme.*

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ButtonBlack)
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            LimboLogo()
        }
        LoginTextFields()
    }
}

@Composable
fun LimboLogo() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
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

@Composable
fun LoginTextFields() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
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
                        modifier = Modifier.padding(12.dp)
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

        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        val passwordIcon = if (passwordVisibility) {
            painterResource(R.drawable.gradient_password_invisible)
        } else painterResource(R.drawable.gradient_password_visible)

        Column() {
            TextField(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(300.dp),
                value = password,
                onValueChange = {
                    password = it
                },
                shape = RoundedCornerShape(20.dp),
                placeholder = {
                    Text(
                        text = "Hasło",
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
                        passwordVisibility = !passwordVisibility
                    }) {
                        Image(
                            painter = passwordIcon,
                            contentDescription = "Hasło",
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Default
                ),
                keyboardActions = KeyboardActions(
                    onAny = {
                        Log.d("LOG_TAG", "Clicked password done")
                    }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = TextWhite,
                    disabledTextColor = TextWhite,
                    backgroundColor = DarkGray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                visualTransformation = if (passwordVisibility) {
                    VisualTransformation.None
                } else PasswordVisualTransformation()
            )
            
            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Zapomniałeś hasła?",
                color = TextLightOrange,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { Log.d("LOG_TAG", "Forgot password clicked") }
            )
        }
    }
}