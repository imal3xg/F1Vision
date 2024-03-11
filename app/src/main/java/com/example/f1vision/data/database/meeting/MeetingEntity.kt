package com.example.f1vision.data.database.meeting

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.f1vision.data.repository.Meeting

@Entity(tableName = "meeting")
data class MeetingEntity (
    @PrimaryKey
    val circuitKey: Long,
    val circuitShortName: String,
    val meetingKey: Long,
    val meetingCode: String,
    val location: String,
    val countryKey: Long,
    val countryCode: String,
    val countryName: String,
    val meetingName: String,
    val meetingOfficialName: String,
    val gmtOffset: String,
    val dateStart: String,
    val year: Long
)

fun List<MeetingEntity>.asListMeeting(): List<Meeting> {
    return this.map {
        Meeting(
            it.circuitKey,
            it.circuitShortName,
            it.meetingKey,
            it.meetingCode,
            it.location,
            it.countryKey,
            it.countryCode,
            it.countryName,
            it.meetingName,
            it.meetingOfficialName,
            it.gmtOffset,
            it.dateStart,
            it.year,
        )
    }
}