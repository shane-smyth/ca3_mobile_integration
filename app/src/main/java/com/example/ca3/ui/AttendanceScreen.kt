package com.example.ca3.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ca3.model.SubjectClass

data class AttendanceRecord(
    val date: String,
    val status: AttendanceStatus,
    val subjectClass: SubjectClass
)

enum class AttendanceStatus {
    PRESENT,
    LATE,
    ABSENT
}

@Composable
fun AttendanceScreen(navController: NavController) {
    val attendanceRecords = listOf(
        AttendanceRecord(
            date = "2025-01-15",
            status = AttendanceStatus.PRESENT,
            subjectClass = SubjectClass(
                className = "Math",
                classID = "M101",
                classTeacher = "Mr. Byrne",
                imageURL = "",
                classTimes = mutableListOf("Mon 9:00"),
                totalClasses = 20,
                present = 18,
                late = 1,
                absent = 1
            )
        ),
        AttendanceRecord(
            date = "2025-01-15",
            status = AttendanceStatus.LATE,
            subjectClass = SubjectClass(
                className = "English",
                classID = "E102",
                classTeacher = "Ms. Clark",
                imageURL = "",
                classTimes = mutableListOf("Tue 11:00"),
                totalClasses = 22,
                present = 20,
                late = 1,
                absent = 1
            )
        ),
        AttendanceRecord(
            date = "2025-01-14",
            status = AttendanceStatus.PRESENT,
            subjectClass = SubjectClass(
                className = "Science",
                classID = "S103",
                classTeacher = "Dr. Kelly",
                imageURL = "",
                classTimes = mutableListOf("Mon 13:00"),
                totalClasses = 18,
                present = 17,
                late = 0,
                absent = 1
            )
        ),
        AttendanceRecord(
            date = "2025-01-14",
            status = AttendanceStatus.ABSENT,
            subjectClass = SubjectClass(
                className = "History",
                classID = "H104",
                classTeacher = "Mr. O'Neill",
                imageURL = "",
                classTimes = mutableListOf("Tue 14:00"),
                totalClasses = 15,
                present = 14,
                late = 1,
                absent = 0
            )
        ),
        AttendanceRecord(
            date = "2025-01-13",
            status = AttendanceStatus.PRESENT,
            subjectClass = SubjectClass(
                className = "Art",
                classID = "A105",
                classTeacher = "Ms. Walsh",
                imageURL = "",
                classTimes = mutableListOf("Fri 10:00"),
                totalClasses = 12,
                present = 12,
                late = 0,
                absent = 0
            )
        ),
        AttendanceRecord(
            date = "2025-01-12",
            status = AttendanceStatus.PRESENT,
            subjectClass = SubjectClass(
                className = "PE",
                classID = "P106",
                classTeacher = "Coach Murphy",
                imageURL = "",
                classTimes = mutableListOf("Thu 15:00"),
                totalClasses = 16,
                present = 15,
                late = 0,
                absent = 1
            )
        )
    )

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("My Attendance", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))

            AttendanceSummary(attendanceRecords)

            Spacer(Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .padding(horizontal = 8.dp)
            ) {
                items(attendanceRecords) { record ->
                    AttendanceCard(record)
                }
            }
        }
    }
}

@Composable
fun AttendanceSummary(records: List<AttendanceRecord>) {
    val presentCount = records.count { it.status == AttendanceStatus.PRESENT }
    val lateCount = records.count { it.status == AttendanceStatus.LATE }
    val absentCount = records.count { it.status == AttendanceStatus.ABSENT }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        SummaryCard("Present", presentCount, Color(0xFF4CAF50))
        SummaryCard("Late", lateCount, Color(0xFFFF9800))
        SummaryCard("Absent", absentCount, Color(0xFFF44336))
    }
}

@Composable
fun SummaryCard(label: String, count: Int, color: Color) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFEFEF)),
        modifier = Modifier
            .width(100.dp)
            .height(80.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(color)
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = count.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun AttendanceCard(record: AttendanceRecord, modifier: Modifier = Modifier) {
    val statusColor = when (record.status) {
        AttendanceStatus.PRESENT -> Color(0xFF4CAF50)
        AttendanceStatus.LATE -> Color(0xFFFF9800)
        AttendanceStatus.ABSENT -> Color(0xFFF44336)
    }

    val statusText = when (record.status) {
        AttendanceStatus.PRESENT -> "Present"
        AttendanceStatus.LATE -> "Late"
        AttendanceStatus.ABSENT -> "Absent"
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFEFEF)),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(statusColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = statusText.first().toString(),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = record.subjectClass.className,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "${record.subjectClass.classID} • ${record.subjectClass.classTeacher}",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = record.date,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(statusColor.copy(alpha = 0.2f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = statusText,
                    color = statusColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
