package com.app.limboapp.nav

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.limboapp.screens.ChaptersScreen
import com.app.limboapp.screens.HomeScreen
import com.app.limboapp.screens.ProfileScreen
import com.app.limboapp.screens.StatsScreen

fun NavGraphBuilder.limboNavGraph(
    modifier: Modifier
) {
    navigation(
        route = Graph.LIMBO,
        startDestination = LimboNavGraph.Home.route
    ) {
        composable(LimboNavGraph.Home.route) {
            HomeScreen(modifier = modifier)
        }
        composable(LimboNavGraph.Chapters.route) {
            ChaptersScreen(modifier = modifier)
        }
        composable(LimboNavGraph.Stats.route) {
            StatsScreen(modifier = modifier)
        }
        composable(LimboNavGraph.Profile.route) {
            ProfileScreen(modifier = modifier)
        }
    }
}

sealed class LimboNavGraph(val route: String) {
    object Home : LimboNavGraph(route = "home_screen")
    object Chapters : LimboNavGraph(route = "chapters_screen")
    object Stats : LimboNavGraph(route = "stats_screen")
    object Profile : LimboNavGraph(route = "profile_screen")
}