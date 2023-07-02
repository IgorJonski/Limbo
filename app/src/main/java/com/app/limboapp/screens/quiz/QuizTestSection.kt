package com.app.limboapp.screens.quiz

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.limboapp.R
import com.app.limboapp.model.Question
import com.app.limboapp.ui.theme.BackgroundWhite
import com.app.limboapp.ui.theme.Montserrat
import com.app.limboapp.ui.theme.TextWhite
import com.app.limboapp.ui.theme.orangeGradient

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

@Composable
fun QuizProgressSection(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        QuizTimeLeftBar()
        Spacer(modifier = Modifier.width(34.dp))
        QuizQuestionsLeft()
    }
}

@Composable
fun QuizQuestion(
    modifier: Modifier = Modifier,
    question: Question
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = question.text,
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 17.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        if (question.image != null) {
            Image(
                painter = painterResource(id = question.image),
                contentDescription = "Question image",
                modifier = Modifier
                    .fillMaxWidth(0.7f),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun QuizAnswerButton(
    modifier: Modifier = Modifier,
    answerText: String,
    isSelected: Boolean = false
) {
    val answerIcon = if (isSelected) {
        R.drawable.ic_answer_selected
    } else R.drawable.ic_answer_not_selected

    Box(
        modifier = modifier
            .width(200.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Transparent)
            .border(
                width = 1.dp,
                brush = orangeGradient,
                shape = RoundedCornerShape(25.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = answerText,
            color = TextWhite,
            fontFamily = Montserrat,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )
        Image(
            painter = painterResource(id = answerIcon),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(20.dp)
                .align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun QuizAnswersSection(
    modifier: Modifier = Modifier,
    question: Question
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        QuizAnswerButton(answerText = question.wrongAnswers[0])
        QuizAnswerButton(answerText = question.wrongAnswers[1])
        QuizAnswerButton(answerText = question.correctAnswer)
        QuizAnswerButton(answerText = question.wrongAnswers[2])
    }
}

@Composable
fun QuizTestSection(
    modifier: Modifier = Modifier,
    question: Question
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QuizProgressSection()
        Spacer(modifier = Modifier.height(25.dp))
        QuizQuestion(question = question)
        Spacer(modifier = Modifier.height(25.dp))
        QuizAnswersSection(question = question)
    }
}

// --------------------

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

@Preview
@Composable
fun QuizProgressSectionPreview() {
    QuizProgressSection()
}

@Preview
@Composable
fun QuizQuestionPreview() {
    val testQuestion = Question(
        text = "Ile będzie równa zmienna licznik po wykonaniu tego kodu?",
        image = R.drawable.quiz1,
        wrongAnswers = arrayListOf("5", "0", "3"),
        correctAnswer = "-5"
    )
    QuizQuestion(question = testQuestion)
}

@Preview
@Composable
fun QuizAnswerButtonPreview() {
    QuizAnswerButton(
        answerText = "-5"
    )
}

@Preview
@Composable
fun QuizAnswersSectionPreview() {
    val testQuestion = Question(
        text = "Ile będzie równa zmienna licznik po wykonaniu tego kodu?",
        image = R.drawable.quiz1,
        wrongAnswers = arrayListOf("5", "0", "3"),
        correctAnswer = "-5"
    )
    QuizAnswersSection(question = testQuestion)
}

@Preview
@Composable
fun QuizTestSectionPreview() {
    val testQuestion = Question(
        text = "Ile będzie równa zmienna licznik po wykonaniu tego kodu?",
        image = R.drawable.quiz1,
        wrongAnswers = arrayListOf("5", "0", "3"),
        correctAnswer = "-5"
    )
    QuizTestSection(question = testQuestion)
}