package com.example.f1vision.data.database.driver

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.f1vision.data.repository.Driver

@Entity(tableName = "driver")
data class DriverEntity (
    @PrimaryKey
    val sessionKey: Long,
    val meetingKey: Long,
    val broadcastName: String,
    val countryCode: String,
    val firstName: String,
    val fullName: String,
    val headshotUrl: String?,
    val lastName: String,
    val driverNumber: Long,
    val teamColour: String?, // Este tipo de dato puede ser ajustado según el tipo de datos que necesites
    val teamName: String,
    val nameAcronym: String
)

fun List<DriverEntity>.asListDriver(): List<Driver> {
    return this.map {
        Driver(
            it.sessionKey,
            it.meetingKey,
            it.broadcastName,
            it.countryCode,
            it.firstName,
            it.fullName,
            it.headshotUrl,
            it.lastName,
            it.driverNumber,
            it.teamColour,
            it.teamName,
            it.nameAcronym
        )
    }
}