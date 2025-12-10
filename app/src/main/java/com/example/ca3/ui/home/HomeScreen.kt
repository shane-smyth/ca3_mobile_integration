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

import com.example.ca3.ui.home.DashboardCard

@Composable
fun HomeScreen() {
    // screen adaptation
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val isTablet = screenWidth > 600

    val padding = if (isTablet) 32.dp else 16.dp
    val cardHeight = if (isTablet) 260.dp else 180.dp
    val titleSize = if (isTablet) 34.sp else 24.sp
    val bodySize = if (isTablet) 20.sp else 14.sp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        // Title
        Text(
            text = "EduSense",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = titleSize,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(12.dp))


        DashboardCard(
            title = "Attendance Overview",
            description = "Track your attendance across all classes.",
            imageUrl = "https://picsum.photos/600/400",
            height = cardHeight
        )

        Spacer(modifier = Modifier.height(16.dp))

        DashboardCard(
            title = "Upcoming Classes",
            description = "See what class is scheduled next.",
            imageUrl = "https://picsum.photos/600/401",
            height = cardHeight
        )

        Spacer(modifier = Modifier.height(16.dp))

        DashboardCard(
            title = "Profile Settings",
            description = "View and update your personal info.",
            imageUrl = "https://picsum.photos/600/402",
            height = cardHeight
        )
    }
}