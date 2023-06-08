package com.app.limboapp.nav

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.rootNavigation(
    navController: NavHostController,
) {
    navigation(
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        authNavGraph(navController)
        limboNavGraph(Modifier)
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTH = "auth_graph"
    const val LIMBO = "limbo_graph"
}