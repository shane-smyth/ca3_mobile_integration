package com.example.ca3.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ca3.ui.theme.Ca3Theme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Home Screen")

        Button(onClick = { /* TODO: Navigation later */ }) {
            Text("Go to Attendance")
        }

        Button(onClick = { /* TODO: Navigation later */ }) {
            Text("Go to Classes")
        }

        Button(onClick = { /* TODO: Navigation later */ }) {
            Text("Go to Profile")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Ca3Theme {
        HomeScreen()
    }
}
