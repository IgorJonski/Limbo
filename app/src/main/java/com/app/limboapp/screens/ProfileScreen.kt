package com.app.limboapp.screens

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.common.CircleImage
import com.app.limboapp.common.CustomTextField
import com.app.limboapp.common.GradientButton
import com.app.limboapp.ui.theme.*

@Preview
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ProfileSection(modifier = modifier.background(BlackBackground))
}

@Composable
fun ProfileSection(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        ProfileInfo()
        ChangePassword(Modifier.padding(top = 16.dp))
        RedeemFlickersSection(Modifier.padding(top = 30.dp, bottom = 16.dp))
    }
}

@Composable
fun ChangePassword(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
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
        var oldPassword by rememberSaveable { mutableStateOf("") }
        CustomTextField(
            value = oldPassword,
            onValueChange = { oldPassword = it },
            hint = "Stare hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ) {
            Log.d("LOG_TAG", "Finished $oldPassword")
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
        var newPassword by rememberSaveable { mutableStateOf("") }
        CustomTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            hint = "Nowe hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ) {
            Log.d("LOG_TAG", "Finished $oldPassword")
        }

        Spacer(modifier = Modifier.height(10.dp))

        var repeatNewPassword by rememberSaveable { mutableStateOf("") }
        CustomTextField(
            value = repeatNewPassword,
            onValueChange = { repeatNewPassword = it },
            hint = "Powtórz nowe hasło",
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        ) {
            Log.d("LOG_TAG", "Finished $oldPassword")
        }

        Spacer(modifier = Modifier.height(16.dp))

        GradientButton(
            text = "Zmień hasło",
            textColor = TextWhite,
            gradient = orangeGradient,
            width = 0.45f
        ) {

        }
    }
}

@Composable
fun RedeemFlickersCard(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(horizontal = 26.dp)
            .clip(RoundedCornerShape(26.dp))
            .border(
                width = 1.5.dp,
                brush = orangeGradient,
                shape = RoundedCornerShape(26.dp)
            )
            .background(horizontalBlackGradient)
            .padding(start = 26.dp, end = 16.dp, top = 20.dp, bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(2f)
        ) {
            Text(
                text = "Płomyki do wymiany",
                color = TextWhite,
                fontSize = 16.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "49",
                color = TextOrange,
                fontSize = 30.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = "Kliknij aby przejeść do ekranu wymiany płomyków.",
                color = TextWhite,
                fontSize = 12.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_redeem),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun RedeemFlickersSection(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "Wymień punkty na bonusy",
            color = TextWhite,
            fontSize = 16.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.paddingFromBaseline(bottom = 18.dp)
        )
        RedeemFlickersCard()
    }
}

@Composable
fun ProfileInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
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
    }
}

// ---------------------

@Preview
@Composable
fun RedeemFlickersPreview() {
    RedeemFlickersCard()
}

@Preview
@Composable
fun RedeemFlickersSectionPreview() {
    RedeemFlickersSection()
}

@Preview
@Composable
fun ProfileInfoPreview() {
    ProfileInfo()
}

@Preview
@Composable
fun ProfileSectionPreview() {
    ProfileSection()
}