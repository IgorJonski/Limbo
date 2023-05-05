package com.app.limboapp.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.ui.theme.*

@Preview
@Composable
fun ChaptersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            LimboLogoWithPointsAndProfile()
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Rozdziały",
                color = TextWhite,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Medium,
                fontSize = 22.sp
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Chapter(
                borderGradient = greenGradient,
                borderWidth = 2.dp,
                title = "Operacje na danych",
                gainedPoints = 14,
                pointsColor = LightGreen
            )
        }
    }
}

@Composable
fun LimboLogoWithPointsAndProfile() {
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
            CircleImage(
                imageID = R.drawable.profile_pic,
                contentDescription = "Profile",
                size = 40.dp,
                onClick = {

                }
            )
        }
    }
}

@Composable
fun Chapter(
    borderGradient: Brush,
    borderWidth: Dp,
    title: String,
    maxPoints: Int = 15,
    gainedPoints: Int,
    pointsColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = borderWidth,
                brush = borderGradient,
                shape = RoundedCornerShape(20.dp)
            )
            .background(BlackBackground)
            .padding(horizontal = 14.dp, vertical = 18.dp)
            .clickable { }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    color = TextWhite,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
                Text(
                    text = "Zdobyte punkty",
                    color = TextWhite,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                )
                Text(
                    text = "$gainedPoints/$maxPoints",
                    color = pointsColor,
                    fontFamily = Montserrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
            Image(
                painter = painterResource(id = R.drawable.ic_redeem),
                contentDescription = "Wymień płomyki",
                modifier = Modifier
                    .weight(1f)
                    .shadow(
                        elevation = 16.dp,
                        ambientColor = Color.Transparent,
                        spotColor = LightGreen,
                        shape = CircleShape
                    )
            )
        }
    }
}