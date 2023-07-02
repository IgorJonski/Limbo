package com.app.limboapp.model

import androidx.annotation.DrawableRes

/**
 * Question holds multiple [wrongAnswers] and one [correctAnswer].
 * While displaying Question we will always pick 3 random wrong answers and 1 correct.
 *
 * If [image] is null, then that means this question is [text]-only.
 */
data class Question(
    val text: String,
    @DrawableRes val image: Int?,
    val wrongAnswers: ArrayList<String>,
    val correctAnswer: String
)