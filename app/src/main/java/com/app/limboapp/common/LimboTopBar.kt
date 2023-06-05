package com.app.limboapp.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.model.TopBarMode
import com.app.limboapp.ui.theme.DarkGray
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextOrange
import com.app.limboapp.ui.theme.TextWhite

@Composable
fun LimboLogo(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
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
fun Flickers(modifier: Modifier = Modifier) {

    val points by remember { mutableStateOf(50) }

    Flickers(
        modifier = modifier,
        flickers = points,
        onClick = { }
    )
}

@Composable
fun Flickers(
    modifier: Modifier = Modifier,
    flickers: Int,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(DarkGray)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.limbo_flame),
            contentDescription = "Flickers",
            modifier = Modifier
                .padding(6.dp)
                .size(20.dp)
        )
        Text(
            text = flickers.toString(),
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(end = 10.dp, top = 8.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun LogoutButton(
    modifier: Modifier = Modifier,
    size: Dp = 26.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(DarkGray)
            .clickable { onClick() }
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logout),
            contentDescription = "Logout",
            modifier = Modifier
                .size(size)
        )
    }
}

@Composable
fun CircleImage(
    modifier: Modifier = Modifier,
    imageID: Int,
    contentDescription: String?,
    size: Dp,
    onClick: () -> Unit = {}
) {
    Image(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .clickable { onClick() },
        painter = painterResource(id = imageID),
        contentDescription = contentDescription
    )
}

@Composable
fun LimboTopBar(
    modifier: Modifier = Modifier,
    mode: TopBarMode
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp)
    ) {
        Flickers(
            Modifier
                .align(Alignment.CenterStart)
                .padding(start = 26.dp)
        )
        LimboLogo(Modifier.align(Alignment.Center))
        if (mode == TopBarMode.LOGOUT) {
            LogoutButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 26.dp),
                onClick = { }
            )
        } else if (mode == TopBarMode.PROFILE) {
            CircleImage(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 30.dp),
                imageID = R.drawable.profile_pic,
                contentDescription = "Profile",
                size = 40.dp
            )
        }
    }
}

// --------------------

@Preview
@Composable
fun LimboTopBarProfilePreview() {
    LimboTopBar(mode = TopBarMode.PROFILE)
}

@Preview
@Composable
fun LimboTopBarLogoutPreview() {
    LimboTopBar(mode = TopBarMode.LOGOUT)
}

@Preview
@Composable
fun LimboLogoPreview() {
    LimboLogo()
}

@Preview
@Composable
fun FlickersPreview() {
    Flickers()
}

@Preview
@Composable
fun LogoutButtonPreview() {
    LogoutButton(
        onClick = { }
    )
}

@Preview
@Composable
fun CircleImagePreview() {
    CircleImage(
        imageID = R.drawable.profile_pic,
        contentDescription = "Profile",
        size = 40.dp
    )
}