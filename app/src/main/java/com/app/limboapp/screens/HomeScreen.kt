package com.app.limboapp.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.model.ChapterData
import com.app.limboapp.model.Person
import com.app.limboapp.nav.LimboBottomNavigation
import com.app.limboapp.ui.theme.BlackBackground
import com.app.limboapp.ui.theme.MiniFlickersBackground
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite
import com.app.limboapp.ui.theme.circleProgressGreenGradient
import com.app.limboapp.ui.theme.circleProgressOrangeGradient
import com.app.limboapp.ui.theme.greenGradient
import com.app.limboapp.ui.theme.horizontalBlackGradient
import com.app.limboapp.ui.theme.orangeGradient
import com.app.limboapp.ui.theme.redGradient

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
    name: String,
    @DrawableRes profilePic: Int,
    flickers: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = profilePic),
                contentDescription = null,
                modifier = Modifier
                    .padding(6.dp)
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            MiniFlickers(
                modifier = Modifier.align(Alignment.BottomEnd),
                flickers = flickers
            )
        }
        Text(
            text = name,
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

@Composable
fun BestInGroupRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        val data = getExampleBestInGroupData()
        items(data) { item ->
            BestInGroupElement(
                name = item.name,
                profilePic = item.profilePic,
                flickers = item.gainedFlickers
            )
        }
    }
}

@Composable
fun BestInGroupSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Najlepsi w grupie",
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(bottom = 16.dp, start = 20.dp)
        )
        BestInGroupRow()
    }
}

@Composable
fun MiniChapter(
    modifier: Modifier = Modifier,
    borderWidth: Dp = 1.dp,
    title: String,
    maxPoints: Int = 15,
    gainedPoints: Int,
    isUnlocked: Boolean = false
) {
    val isCompleted = gainedPoints == maxPoints

    val borderGradient = if (!isUnlocked) {
        redGradient
    } else if (isCompleted) {
        greenGradient
    } else orangeGradient

    val progressColor = if (!isUnlocked) {
        redGradient
    } else if (isCompleted) {
        circleProgressGreenGradient
    } else circleProgressOrangeGradient

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(25.dp))
            .background(horizontalBlackGradient)
            .border(
                width = borderWidth,
                brush = borderGradient,
                shape = RoundedCornerShape(25.dp)
            )
            .padding(top = 14.dp ,bottom = 10.dp)
            .padding(horizontal = 16.dp)
            .height(136.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressBar(
            percentage = (gainedPoints / maxPoints.toFloat()),
            radius = 30.dp,
            progressGradient = progressColor,
            strokeWidth = 5.5.dp,
            isUnlocked = isUnlocked
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .padding(horizontal = 6.dp),
            text = title,
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MiniChapterGrid(modifier: Modifier = Modifier) {
    val data = getFakeMiniChaptersData()
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(data) { item ->
            MiniChapter(
                title = item.title,
                gainedPoints = item.gainedPoints,
                isUnlocked = item.isUnlocked
            )
        }
    }
}

// ------------------

@Preview
@Composable
fun BestInGroupElementPreview() {
    BestInGroupElement(name = "Marek" ,flickers = 15, profilePic = R.drawable.example_person1)
}

@Preview(widthDp = 200)
@Composable
fun BestInGroupRowPreview() {
    BestInGroupRow()
}

@Preview
@Composable
fun BestInGroupSectionPreview() {
    BestInGroupSection()
}

@Preview
@Composable
fun MiniChapterPreview() {
    MiniChapter(title = "Operacje na danych", gainedPoints = 0, isUnlocked = false)
}

@Preview
@Composable
fun MiniChapterGridPreview() {
    MiniChapterGrid()
}

// ------------------

fun getExampleBestInGroupData(): List<Person> {
    return listOf(
        Person("Marek", R.drawable.example_person1, 56),
        Person("Kamil", R.drawable.example_person2, 51),
        Person("Flora", R.drawable.example_person3, 43),
        Person("Joachim", R.drawable.example_person4, 32),
    )
}

fun getFakeMiniChaptersData(): List<ChapterData> {
    return listOf(
        ChapterData("Operacje na danych", 15, 15, true),
        ChapterData("Instrukcje warunkowe", 7, 15, true),
        ChapterData("Pętle, instrukcje iteracyjne", 0, 15),
        ChapterData("Tablice jednowymiarowe", 0, 15)
    )
}