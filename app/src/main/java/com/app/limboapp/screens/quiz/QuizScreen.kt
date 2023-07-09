package com.app.limboapp.screens.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.limboapp.R
import com.app.limboapp.common.GradientButton
import com.app.limboapp.common.LimboTopBar
import com.app.limboapp.model.Question
import com.app.limboapp.model.TopBarMode
import com.app.limboapp.ui.theme.orangeGradient
import com.app.limboapp.ui.theme.verticalQuizBackgroundGradient
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import java.util.concurrent.TimeUnit

@Composable
fun QuizScreen(
    modifier: Modifier = Modifier,
    question: Question  // TODO change to list of questions
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(verticalQuizBackgroundGradient)
    )
    Scaffold(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        topBar = {
            LimboTopBar(mode = TopBarMode.PROFILE)
        },
        content = { paddingValues ->
//            QuizTestSection(
//                modifier = Modifier
//                    .padding(paddingValues)
//                    .padding(top = 40.dp, bottom = 10.dp)
//                ,
//                question = question
//            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                QuizDoneSection(
                    modifier = Modifier.padding(paddingValues),
                    title = "Jesteś niesamowity!",
                    message = "Gratulacje! Zdobyłeś wymaganą liczbę punktów w tym dziale!",
                    gainedFlickers = 10
                )
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                GradientButton(
                    modifier = Modifier.padding(bottom = 40.dp),
                    gradient = orangeGradient,
                    text = "Strona główna",
                    onClick = {  }
                )
            }

        }
    )
    val party = Party(
        speed = 0f,
        maxSpeed = 30f,
        damping = 0.9f,
        spread = 360,
        colors = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def),
        position = Position.Relative(0.5, 0.3),
        emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100)
    )
    KonfettiView(
        modifier = Modifier.fillMaxSize(),
        parties = listOf(party)
    )
}

// --------------------

@Preview
@Composable
fun QuizScreenPreview() {
    val testQuestion = Question(
        text = "Ile będzie równa zmienna licznik po wykonaniu tego kodu?",
        image = R.drawable.quiz1,
        wrongAnswers = arrayListOf("5", "0", "3"),
        correctAnswer = "-5"
    )
    QuizScreen(question = testQuestion)
}