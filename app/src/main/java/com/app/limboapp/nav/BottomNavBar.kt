package com.app.limboapp.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.limboapp.R
import com.app.limboapp.ui.theme.DarkGray

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    items: List<BottomNavItem>,
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backstackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier.height(66.dp),
        backgroundColor = DarkGray
    ) {
        items.forEach { item ->
            val selected = item.route == backstackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                icon = {
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(
                            id = if (selected) {
                                item.selectedIconId
                            } else item.unselectedIconId
                        ),
                        contentDescription = item.name)
                }
            )
        }
    }
}

val bottomNavBarItems = listOf<BottomNavItem>(
    BottomNavItem(
        "Home",
        HOME_SCREEN,
        R.drawable.ic_home,
        R.drawable.ic_selected_home
    ),
    BottomNavItem(
        "Chapters",
        CHAPTERS_SCREEN,
        R.drawable.ic_chapters,
        R.drawable.ic_selected_chapters
    ),
    BottomNavItem(
        "Stats",
        STATS_SCREEN,
        R.drawable.ic_stats,
        R.drawable.ic_selected_stats
    ),
    BottomNavItem(
        "Profile",
        PROFILE_SCREEN,
        R.drawable.ic_profile,
        R.drawable.ic_selected_profile
    )
)