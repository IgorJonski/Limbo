package com.app.limboapp.ui

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.ui.theme.*

@Preview(showBackground = true)
@Composable
fun RegisterScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground)
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            LimboLogo()
        }
        RegisterTextFields()
    }
}

@Composable
fun RegisterTextFields() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
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
        val name = remember { mutableStateOf("") }
        LoginOrRegisterTextField(
            state = name,
            hint = "Imię",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onIconClick = {}
        ) {
            Log.d("LOG_TAG", "Finished ${name.value}")
        }

        Spacer(modifier = Modifier.height(10.dp))
        val surname = remember { mutableStateOf("") }
        LoginOrRegisterTextField(
            state = surname,
            hint = "Nazwisko",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            onIconClick = {}
        ) {
            Log.d("LOG_TAG", "Finished ${surname.value}")
        }
    }
}

@Composable
fun LoginOrRegisterTextField(
    state: MutableState<String>,
    hint: String = "",
    @DrawableRes iconId: Int? = null,
    onIconClick: () -> Unit,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    onKeyboardDone: () -> Unit
) {
    TextField(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(300.dp),
        value = state.value,
        onValueChange = {
            state.value = it
        },
        shape = RoundedCornerShape(20.dp),
        placeholder = {
            Text(
                text = hint,
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
                onIconClick()
            }, enabled = iconId != null
            ) {
                Image(
                    painter = painterResource(
                        id = iconId ?: R.drawable.transparent_icon
                    ),
                    contentDescription = hint,
                    modifier = Modifier.padding(12.dp)
                )
            }
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onAny = {
                onKeyboardDone()
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
}