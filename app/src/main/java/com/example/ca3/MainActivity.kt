package com.example.ca3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ca3.ui.*
import com.example.ca3.ui.home.HomeScreen
import com.example.ca3.ui.navigation.BottomNavBar
import com.example.ca3.ui.navigation.Screen
import com.example.ca3.ui.theme.Ca3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ca3Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Attendance.route) { AttendanceScreen(navController) }
            composable(Screen.Classes.route) { ClassesScreen(navController) }
            composable(Screen.Profile.route) { ProfileScreen() }
            composable(Screen.ClassInfoScreen.route) { ClassInfoScreen(navController) }
        }
    }
}
