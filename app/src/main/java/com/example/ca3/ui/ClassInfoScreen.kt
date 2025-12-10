package com.example.ca3.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.ca3.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


import com.example.ca3.model.SubjectClass
import com.example.ca3.ui.navigation.Screen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ClassInfoScreen(navController: NavController){
    val classInfo: SubjectClass = SubjectClass(
        className = "Maths",
        classID = "M104",
        classTeacher = "Mr Doe",
        imageURL = "",
        classTimes = mutableListOf("Monday, 12:00",
                                    "Tuesday, 13:00",
                                    "Friday: 10:00"),
        totalClasses = 10,
        present = 8,
        late = 2,
        absent = 0
    )


    val navTo = {screen: Screen -> navController.navigate(screen.route) {
        popUpTo(Screen.Home.route)
        launchSingleTop = true
    }}


    Column(modifier = Modifier.fillMaxWidth().padding(vertical=20.dp, horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text=classInfo.className, fontSize = 30.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 10.dp))
        Row(modifier = Modifier.background(color= Color(0xFFEFEFEF),
            shape = RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .padding(horizontal=10.dp),

            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column {
                Text(classInfo.classID, color=Color.Black)
                Text(classInfo.classTeacher, color=Color.Black)
            }
            Image(painter = painterResource(id = R.drawable.grad_cap),
                        contentDescription = "Class Image",
                        modifier = Modifier.fillMaxWidth(0.20f))
        }


        Spacer(modifier = Modifier.height(10.dp))

        //class dates
        Text(text = stringResource(id = R.string.class_times), fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 10.dp))
        Box(modifier = Modifier.fillMaxWidth().padding(horizontal=10.dp).background(color= Color(0xFFEFEFEF), shape = RoundedCornerShape(12.dp))) {
            LazyColumn(modifier = Modifier.fillMaxWidth().padding(horizontal=10.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                items(classInfo.classTimes) { time ->
                    ClassDateTimeRow(time)
                }
            }
        }

        //attendance info
        Text(text = stringResource(id = R.string.attendance_summary), fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(vertical = 10.dp))
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal=10.dp).background(color= Color(0xFFEFEFEF), shape = RoundedCornerShape(12.dp)),
            horizontalAlignment = Alignment.CenterHorizontally) {
            SplitRow(
                first = stringResource(id = R.string.total),
                second = classInfo.totalClasses.toString()
            )

            SplitRow(
                first = stringResource(id = R.string.present),
                second = classInfo.present.toString()
            )

            SplitRow(
                first = stringResource(id = R.string.late),
                second = classInfo.late.toString()
            )

            SplitRow(
                first = stringResource(id = R.string.absent),
                second = classInfo.absent.toString()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { navTo(Screen.Attendance) }) {
            Text(stringResource(id = R.string.view_attendance))
        }
    }




}


@Composable
fun ClassDateTimeRow(dateString: String, modifier: Modifier = Modifier){
    Row(modifier = Modifier.fillMaxWidth(0.8f)){
        Text(text="- " + dateString, textAlign = TextAlign.Start, color = Color.Black, modifier = Modifier.padding(vertical=5.dp))
    }
}

@Composable
fun SplitRow(first: String, second: String, modifier: Modifier = Modifier){
    Row(modifier = Modifier.fillMaxWidth(0.6f).padding(vertical=5.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Text(first + "", color = Color.Black)
        Text(second, color = Color.Black)
    }
}

/*
@Preview
@Composable
fun ClassInfoScreenPreview(){
    ClassInfoScreen()
}

 */


