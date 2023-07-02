package com.app.limboapp.screens.quiz

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.app.limboapp.ui.theme.BackgroundWhite
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite
import com.app.limboapp.ui.theme.orangeGradient

@Composable
fun QuizTestScreen() {

}

@Composable
fun QuizTimeLeftBar(
    modifier: Modifier = Modifier,
    maxTime: Int = 60,
    remainingTime: Int = 36
) {
    val timeLeft = (remainingTime / maxTime.toFloat())

    Box(
        modifier = modifier
            .width(240.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(BackgroundWhite)
    ) {
        Box(
            modifier = Modifier
                .width(240.dp * timeLeft)
                .height(30.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(orangeGradient)
                .align(Alignment.CenterStart)
                .animateContentSize()
        )
        Icon(
            modifier = Modifier
                .padding(end = 6.dp)
                .align(Alignment.CenterEnd)
                .size(22.dp),
            painter = painterResource(id = R.drawable.ic_timer),
            contentDescription = null
        )
    }
}

@Composable
fun QuizQuestionsLeft(
    modifier: Modifier = Modifier,
    numOfQuestions: Int = 10,
    answeredQuestions: Int = 5
) {
    val questionsLeft = "$answeredQuestions/$numOfQuestions"
    Box(
        modifier = modifier
            .height(30.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(orangeGradient)
            .padding(horizontal = 8.dp)
            .animateContentSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = questionsLeft,
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}

// --------------------

@Preview
@Composable
fun QuizTestScreenPreview() {
    QuizTestScreen()
}

@Preview
@Composable
fun QuizTimeLeftBarPreview() {
    QuizTimeLeftBar()
}

@Preview
@Composable
fun QuizQuestionsLeftPreview() {
    QuizQuestionsLeft()
}