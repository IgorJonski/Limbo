package com.app.limboapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.limboapp.common.LimboTopBar
import com.app.limboapp.model.TopBarMode
import com.app.limboapp.nav.BottomNavBar
import com.app.limboapp.nav.Navigation
import com.app.limboapp.nav.bottomNavBarItems
import com.app.limboapp.ui.theme.BlackBackground
import com.app.limboapp.ui.theme.LimboAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimboAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    backgroundColor = BlackBackground,
                    topBar = {
                        LimboTopBar(mode = TopBarMode.PROFILE)
                    },
                    content = {
                        Navigation(
                            modifier = Modifier.padding(it),
                            navController = navController
                        )
                    },
                    bottomBar = {
                        BottomNavBar(items = bottomNavBarItems,
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                )
            }
        }
    }
}