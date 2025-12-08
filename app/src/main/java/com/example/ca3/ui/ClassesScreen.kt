package com.example.ca3.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.ca3.R


@Composable
fun ClassesScreen() {
    val allClasses = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("My Classes", Modifier.size(100.dp))
            Spacer(Modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxHeight(0.8f)
            ){
                items(10) {
                    ClassCard()
                }
            }
        }
    }
}

@Composable
fun ClassCard(){
    Box(Modifier.fillMaxSize()){
        Column {
            /*
            Image(
                painter = painterResource(id = R.drawable.class_image),
                contentDescription = null,
            )

             */
            Text("Class Name")
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text("Class ID")
                Text("Class Teacher")
            }


        }
    }
}

@Composable
@Preview
fun ClassesScreenPreview(){
    ClassesScreen()
}


