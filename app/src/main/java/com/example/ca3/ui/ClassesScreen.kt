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
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.ca3.R
import com.example.ca3.model.SubjectClass
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun ClassesScreen() {
    val allClasses = mutableListOf(
        SubjectClass(
            className = "Math",
            classID = "M101",
            classTeacher = "Mr. Byrne",
            imageURL = "https://example.com/math.jpg",
            classTimes = mutableListOf("Mon 9:00", "Wed 9:00"),
            totalClasses = 20,
            present = 18,
            late = 1,
            absent = 1
        ),
        SubjectClass(
            className = "English",
            classID = "E102",
            classTeacher = "Ms. Clark",
            imageURL = "https://example.com/english.jpg",
            classTimes = mutableListOf("Tue 11:00", "Thu 11:00"),
            totalClasses = 22,
            present = 20,
            late = 1,
            absent = 1
        ),
        SubjectClass(
            className = "Science",
            classID = "S103",
            classTeacher = "Dr. Kelly",
            imageURL = "https://example.com/science.jpg",
            classTimes = mutableListOf("Mon 13:00", "Wed 13:00"),
            totalClasses = 18,
            present = 17,
            late = 0,
            absent = 1
        ),
        SubjectClass(
            className = "History",
            classID = "H104",
            classTeacher = "Mr. O'Neill",
            imageURL = "https://example.com/history.jpg",
            classTimes = mutableListOf("Tue 14:00"),
            totalClasses = 15,
            present = 14,
            late = 1,
            absent = 0
        ),
        SubjectClass(
            className = "Art",
            classID = "A105",
            classTeacher = "Ms. Walsh",
            imageURL = "https://example.com/art.jpg",
            classTimes = mutableListOf("Fri 10:00"),
            totalClasses = 12,
            present = 12,
            late = 0,
            absent = 0
        ),
        SubjectClass(
            className = "PE",
            classID = "P106",
            classTeacher = "Coach Murphy",
            imageURL = "https://example.com/pe.jpg",
            classTimes = mutableListOf("Thu 15:00"),
            totalClasses = 16,
            present = 15,
            late = 0,
            absent = 1
        )
    )

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("My Classes", fontSize=32.sp)
            Spacer(Modifier.height(16.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxHeight(0.8f)
                    .padding(8.dp)
            ){
                items(allClasses) { subjectClass ->
                    ClassCard(subjectClass)
                }
            }
        }
    }
}

@Composable
fun ClassCard(subjectClass: SubjectClass, modifier: Modifier = Modifier){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEFEFEF) // your background color
        ),
        modifier = modifier.padding(8.dp)

    ){
        Column {
            Image(
                painter = painterResource(id = R.drawable.grad_cap),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight()
                    .clip(
                        RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    )
            )


            Text(subjectClass.className, color = Color.Black, fontWeight = FontWeight.Bold ,  modifier = modifier.padding(horizontal=10.dp, vertical=5.dp))
            Row(Modifier.fillMaxWidth().padding(horizontal=10.dp, vertical = 5.dp), horizontalArrangement = Arrangement.SpaceBetween){
                Text(subjectClass.classID, color=Color.Black)
                Text(subjectClass.classTeacher, color=Color.Black, textAlign = TextAlign.End)
            }


        }
    }
}

@Composable
@Preview
fun ClassesScreenPreview(){
    ClassesScreen()
}


