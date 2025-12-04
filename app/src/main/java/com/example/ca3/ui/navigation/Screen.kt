package com.example.ca3.ui.navigation

sealed class Screen(val route: String, val label: String) {
    object Home : Screen("home", "Home")
    object Attendance : Screen("attendance", "Attendance")
    object Classes : Screen("classes", "Classes")
    object Profile : Screen("profile", "Profile")
}
