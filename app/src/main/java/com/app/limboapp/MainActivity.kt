package com.app.limboapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.limboapp.common.LimboTopBar
import com.app.limboapp.model.TopBarMode
import com.app.limboapp.nav.AuthNavGraph
import com.app.limboapp.nav.BottomNavBar
import com.app.limboapp.nav.Graph
import com.app.limboapp.nav.bottomNavBarItems
import com.app.limboapp.nav.rootNavigation
import com.app.limboapp.ui.theme.BlackBackground
import com.app.limboapp.ui.theme.LimboAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimboAppTheme {
                val navController = rememberNavController()
                val currentRoute = navController.currentBackStackEntryAsState()

                Scaffold(
                    backgroundColor = BlackBackground,
                    topBar = {
                        val showTopBar = currentRoute.value?.destination?.route !in arrayOf(
                            AuthNavGraph.First.route,
                            AuthNavGraph.Login.route,
                            AuthNavGraph.Register.route
                        )
                        if (showTopBar) {
                            LimboTopBar(mode = TopBarMode.PROFILE)
                        }
                    },
                    content = { paddingValues ->
                        NavHost(
                            navController = navController,
                            startDestination = Graph.ROOT,
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            rootNavigation(navController = navController)
                        }
                    },
                    bottomBar = {
                        val showBottomBar = currentRoute.value?.destination?.route !in arrayOf(
                            AuthNavGraph.First.route,
                            AuthNavGraph.Login.route,
                            AuthNavGraph.Register.route
                        )
                        if (showBottomBar) {
                            BottomNavBar(items = bottomNavBarItems,
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}