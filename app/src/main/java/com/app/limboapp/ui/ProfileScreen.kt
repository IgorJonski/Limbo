package com.app.limboapp.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.ui.theme.*

@Preview
@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LimboLogoWithPointsAndLogout()
        }
        Spacer(modifier = Modifier.height(8.dp))
        CircleImage(
            imageID = R.drawable.profile_pic,
            contentDescription = "Profile picture",
            size = 100.dp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Igor Joński",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        Text(
            text = "jonskiigor@gmail.com",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Light,
            fontSize = 14.sp
        )
        ChangePassword()
        RedeemFlickers()
    }
}

@Composable
fun LimboLogoWithPointsAndLogout() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
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
            Flickers()
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
                color = TextOrange
            )
        }
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            LogoutButton()
        }
    }
}

@Composable
fun Flickers() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(DarkGray)
            .clickable { }
    ) {
        Image(
            painter = painterResource(id = R.drawable.limbo_flame),
            contentDescription = "Flickers",
            modifier = Modifier
                .padding(6.dp)
                .size(20.dp)
        )
        val points by remember { mutableStateOf(50) }
        Text(
            text = points.toString(),
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(end = 10.dp, start = 6.dp, top = 8.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun LogoutButton() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(DarkGray)
            .clickable { }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logout),
            contentDescription = "Logout",
            modifier = Modifier
                .size(20.dp)
        )
    }
}

@Composable
fun CircleImage(
    imageID: Int,
    contentDescription: String,
    size: Dp,
) {
    Image(
        painter = painterResource(id = imageID),
        contentDescription = contentDescription,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
    )
}

@Composable
fun ChangePassword() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Zmień hasło",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp)
        )
        val oldPassword = rememberSaveable { mutableStateOf("") }
        CustomTextField(
            state = oldPassword,
            hint = "Stare hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ) {
            Log.d("LOG_TAG", "Finished ${oldPassword.value}")
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
        val newPassword = rememberSaveable { mutableStateOf("") }
        CustomTextField(
            state = newPassword,
            hint = "Nowe hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ) {
            Log.d("LOG_TAG", "Finished ${oldPassword.value}")
        }

        Spacer(modifier = Modifier.height(10.dp))

        val repeatNewPassword = rememberSaveable { mutableStateOf("") }
        CustomTextField(
            state = repeatNewPassword,
            hint = "Powtórz nowe hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ) {
            Log.d("LOG_TAG", "Finished ${oldPassword.value}")
        }

        Spacer(modifier = Modifier.height(20.dp))
        GradientButton(
            text = "Zmień hasło",
            textColor = TextWhite,
            gradient = horizontalOrangeGradient,
            width = 0.5f
        ) {

        }
    }
}

@Composable
fun RedeemFlickers() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Wymień płomyki na bonusy",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .border(
                    width = 4.dp,
                    brush = horizontalOrangeGradient,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(horizontalBlackGradient)
                .padding(horizontal = 14.dp, vertical = 18.dp)
                .clickable {  }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Płomyki do wymiany",
                        color = TextWhite,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "49",
                        color = TextOrange,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Kliknij, aby przejść do ekranu wymiany płomyków",
                        color = TextWhite,
                        fontFamily = Montserrat,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_redeem),
                    contentDescription = "Wymień płomyki",
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}