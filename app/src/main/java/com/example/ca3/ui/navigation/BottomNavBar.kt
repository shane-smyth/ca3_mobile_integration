package com.example.ca3.ui.navigation

import android.util.Log
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

@Composable
fun BottomNavBar(navController: NavController) {

    val items = listOf(
        Screen.Home,
        Screen.Attendance,
        Screen.Classes,
        Screen.Profile
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        items.forEach { screen ->
            val selected = navBackStackEntry?.destination?.route == screen.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    Log.d("Navigation", "Navigating to ${screen.route}")
                    navController.navigate(screen.route) {
                        popUpTo(Screen.Home.route)
                        launchSingleTop = true
                    }
                },
                label = { Text(screen.label) },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.label
                    )
                }
            )
        }
    }
}