package com.app.limboapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.limboapp.R
import com.app.limboapp.ui.theme.DarkGray

@Composable
fun LimboBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        modifier = modifier.height(66.dp),
        backgroundColor = DarkGray
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = {},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp)
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_chapters),
                    contentDescription = "Chapters",
                    modifier = Modifier.size(24.dp)
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_stats),
                    contentDescription = "Statistics",
                    modifier = Modifier.size(24.dp)
                )
            }
        )
        BottomNavigationItem(
            selected = false,
            onClick = {},
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(24.dp)
                )
            }
        )
    }
}

@Preview
@Composable
fun LimboBottomNavigationPreview() {
    LimboBottomNavigation()
}