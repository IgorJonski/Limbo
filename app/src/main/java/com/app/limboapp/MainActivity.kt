package com.app.limboapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.app.limboapp.ui.ProfileScreen
import com.app.limboapp.ui.RegisterScreen
import com.app.limboapp.ui.theme.LimboAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimboAppTheme {
                ProfileScreen()
            }
        }
    }
}