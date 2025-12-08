package com.example.ca3.model

data class SubjectClass(
    val className: String,
    val classID: String,
    val classTeacher: String,
    val imageURL: String,
    val classTimes: MutableList<String>,
    val totalClasses: Int,
    val present: Int,
    val late: Int,
    val absent: Int
)