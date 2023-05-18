package com.app.limboapp.model

data class ChapterData(
    val title: String,
    val gainedPoints: Int,
    val maxPoints: Int = 15,
    val isUnlocked: Boolean = false
)