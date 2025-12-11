package com.example.ca3.model
import kotlinx.serialization.Serializable


@Serializable
data class SubjectClass(
    val className: String,
    val classID: String,
    val classTeacher: String,
    val imageURL: String,
    val classTimes: List<String>,
    val totalClasses: Int,
    val present: Int,
    val late: Int,
    val absent: Int
)