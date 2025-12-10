package com.example.ca3.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Filled.Home)
    object Attendance : Screen("attendance", "Attendance", Icons.Filled.EventAvailable)
    object Classes : Screen("classes", "Classes", Icons.Filled.School)
    object Profile : Screen("profile", "Profile", Icons.Filled.Person)
    object ClassInfoScreen: Screen("class_info", "Class Info", Icons.Filled.EventAvailable)

}

