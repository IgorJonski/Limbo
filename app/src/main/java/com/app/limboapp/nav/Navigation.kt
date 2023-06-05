package com.app.limboapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.limboapp.screens.ChaptersScreen
import com.app.limboapp.screens.HomeScreen
import com.app.limboapp.screens.ProfileScreen
import com.app.limboapp.screens.StatsScreen

const val HOME_SCREEN = "home_screen"
const val CHAPTERS_SCREEN = "chapters_screen"
const val STATS_SCREEN = "stats_screen"
const val PROFILE_SCREEN = "profile_screen"

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME_SCREEN) {
        composable(HOME_SCREEN) {
            HomeScreen()
        }
        composable(CHAPTERS_SCREEN) {
            ChaptersScreen()
        }
        composable(STATS_SCREEN) {
            StatsScreen()
        }
        composable(PROFILE_SCREEN) {
            ProfileScreen()
        }
    }
}