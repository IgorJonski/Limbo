package com.app.limboapp.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

fun NavGraphBuilder.authNavGraph(navController: NavController) {

}

sealed class AuthNavGraph(val route: String) {
    object First : AuthNavGraph(route = "first_screen")
    object Login : AuthNavGraph(route = "login_screen")
    object Register : AuthNavGraph(route = "register_screen")
    object ForgotPassword : AuthNavGraph(route = "forgot_password_screen")
}