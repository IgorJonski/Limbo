package com.app.limboapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.nav.LimboBottomNavigation
import com.app.limboapp.ui.theme.BlackBackground
import com.app.limboapp.ui.theme.MiniFlickersBackground
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Scaffold(
        backgroundColor = BlackBackground,
        topBar = {
            LimboLogoWithPointsAndProfile()
        },
        bottomBar = {
            LimboBottomNavigation()
        }
    ) {

    }
}

@Composable
fun BestInGroupElement(
    modifier: Modifier = Modifier,
    flickers: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.example_person),
                contentDescription = null,
                modifier = Modifier
                    .padding(6.dp)
                    .size(80.dp)
                    .clip(CircleShape)
            )
            MiniFlickers(
                modifier = Modifier.align(Alignment.BottomEnd),
                flickers = flickers
            )
        }
        Text(
            text = "Marek",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            modifier = Modifier.paddingFromBaseline(top = 16.dp)
        )
    }
}

@Composable
fun MiniFlickers(
    modifier: Modifier = Modifier,
    flickers: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MiniFlickersBackground)
            .clickable { }
    ) {
        Image(
            painter = painterResource(id = R.drawable.limbo_flame),
            contentDescription = "Flickers",
            modifier = Modifier
                .padding(6.dp)
                .size(12.dp)
        )
        Text(
            text = flickers.toString(),
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(end = 8.dp, top = 2.dp, bottom = 2.dp)
        )
    }
}

// ------------------

@Preview
@Composable
fun BestInGroupElementPreview() {
    BestInGroupElement(flickers = 15)
}