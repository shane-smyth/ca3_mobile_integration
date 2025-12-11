package com.example.ca3.ui.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ca3.R
import com.example.ca3.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val isTablet = screenWidth > 600

    val padding = if (isTablet) 32.dp else 16.dp
    val cardHeight = if (isTablet) 200.dp else 150.dp
    val logoSize = if (isTablet) 140.dp else 90.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        item {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .height(logoSize)
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(18.dp))
        }

        item {
            DashboardCard(
                title = "Attendance Overview",
                description = "Track attendance across all classes.",
                icon = Icons.Filled.EventAvailable,
                height = cardHeight,
                onClick = { navController.navigate(Screen.Attendance.route) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardCard(
                title = "Upcoming Classes",
                description = "See your next scheduled classes.",
                icon = Icons.Filled.School,
                height = cardHeight,
                onClick = { navController.navigate(Screen.Classes.route) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardCard(
                title = "Profile Settings",
                description = "Update your personal information.",
                icon = Icons.Filled.Person,
                height = cardHeight,
                onClick = { navController.navigate(Screen.Profile.route) }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}