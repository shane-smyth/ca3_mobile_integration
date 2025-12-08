package com.example.ca3.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ca3.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

import com.example.ca3.model.SubjectClass

@Composable
fun ClassInfoScreen(modifier: Modifier = Modifier){
    val classInfo: SubjectClass = SubjectClass(
        className = "Class Name",
        classID = "Class ID",
        classTeacher = "Class Teacher",
        imageURL = "",
        classTimes = mutableListOf("Monday, 12:00",
                                    "Tuesday, 13:00",
                                    "Friday: 10:00"),
        totalClasses = 10,
        present = 8,
        late = 2,
        absent = 0
    )

    Text(classInfo.className)
    Row(){
        Text(classInfo.classID)
        Text(classInfo.classTeacher)
    }


    //class dates
    Text(text = stringResource(id = R.string.class_times))
    Box{
        LazyColumn {
            items(classInfo.classTimes) { time ->
                ClassDateTimeRow(time)
            }
        }
    }

    //attendance info
    Text(text= stringResource(id = R.string.attendance_summary))
    Box {
        SplitRow( first = stringResource(id= R.string.total),
                    second=classInfo.totalClasses.toString())

        SplitRow( first = stringResource(id= R.string.present),
            second=classInfo.present.toString())

        SplitRow( first = stringResource(id= R.string.late),
            second=classInfo.late.toString())

        SplitRow( first = stringResource(id= R.string.absent),
            second=classInfo.absent.toString())
    }

    Button(onClick = { /*TODO*/ }) {
        Text(stringResource(id = R.string.view_attendance))
    }




}


@Composable
fun ClassDateTimeRow(dateString: String, modifier: Modifier = Modifier){
    Row(modifier = modifier){
        Text(dateString)
    }
}

@Composable
fun SplitRow(first: String, second: String, modifier: Modifier = Modifier){
    Row(modifier = modifier){
        Text(first)
        Text(second)
    }
}


@Preview
@Composable
fun ClassInfoScreenPreview(){
    ClassInfoScreen()
}


