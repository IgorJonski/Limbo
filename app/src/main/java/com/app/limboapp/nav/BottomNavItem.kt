package com.app.limboapp.nav

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val name: String,
    val route: String,
    @DrawableRes val unselectedIconId: Int,
    @DrawableRes val selectedIconId: Int,
)
