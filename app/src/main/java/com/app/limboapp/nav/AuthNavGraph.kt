package com.app.limboapp.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.limboapp.screens.LoginScreen
import com.app.limboapp.screens.RegisterScreen
import com.app.limboapp.screens.FirstScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthNavGraph.First.route
    ) {
        composable(route = AuthNavGraph.First.route) {
            FirstScreen(
                onLoginClick = {
                    navController.navigate(AuthNavGraph.Login.route)
                },
                onRegisterClick = {
                    navController.navigate(AuthNavGraph.Register.route)
                }
            )
        }
        composable(route = AuthNavGraph.Login.route) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Graph.LIMBO)
                }
            )
        }
        composable(route = AuthNavGraph.Register.route) {
            RegisterScreen(
                onRegisterClick = {
                    navController.navigate(AuthNavGraph.Login.route)
                }
            )
        }
    }
}

sealed class AuthNavGraph(val route: String) {
    object First : AuthNavGraph(route = "first_screen")
    object Login : AuthNavGraph(route = "login_screen")
    object Register : AuthNavGraph(route = "register_screen")
}