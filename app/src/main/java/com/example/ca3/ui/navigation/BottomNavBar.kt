package com.example.ca3.ui.navigation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ca3.ui.navigation.Screen

@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf(
        Screen.Home,
        Screen.Attendance,
        Screen.Classes,
        Screen.Profile
    )

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()

        items.forEach { screen ->
            val selected = navBackStackEntry.value?.destination?.route == screen.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Home.route)
                        launchSingleTop = true
                    }
                },
                label = { Text(screen.label) },
                icon = { Text("•") } // placeholder bullet icon
            )
        }
    }
}
