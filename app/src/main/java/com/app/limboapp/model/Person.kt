package com.app.limboapp.model

import androidx.annotation.DrawableRes

data class Person(
    val name: String,
    @DrawableRes val profilePic: Int,
    val gainedFlickers: Int
)
