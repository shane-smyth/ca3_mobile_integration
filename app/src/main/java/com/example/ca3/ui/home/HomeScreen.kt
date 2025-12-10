package com.example.ca3.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.ca3.R

import com.example.ca3.ui.home.DashboardCard
import com.example.ca3.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    // screen adaptation
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val isTablet = screenWidth > 600

    val padding = if (isTablet) 32.dp else 16.dp
    val cardHeight = if (isTablet) 260.dp else 180.dp
    val titleSize = if (isTablet) 42.sp else 30.sp
    val bodySize = if (isTablet) 20.sp else 14.sp
    val logoSize = if (isTablet) 140.dp else 90.dp

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )  {
        // Title
        item {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .height(logoSize)
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))
        }


        item {
            DashboardCard(
                title = "Attendance Overview",
                description = "Track your attendance across all classes.",
                imageUrl = "https://picsum.photos/600/400",
                height = cardHeight,
                onClick = {
                    navController.navigate(Screen.Attendance.route)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardCard(
                title = "Upcoming Classes",
                description = "See what class is scheduled next.",
                imageUrl = "https://picsum.photos/600/401",
                height = cardHeight,
                onClick = {
                    navController.navigate(Screen.Classes.route)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DashboardCard(
                title = "Profile Settings",
                description = "View and update your personal info.",
                imageUrl = "https://picsum.photos/600/402",
                height = cardHeight,
                onClick = {
                    navController.navigate(Screen.Profile.route)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}