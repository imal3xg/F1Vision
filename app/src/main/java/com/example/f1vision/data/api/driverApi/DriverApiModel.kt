package com.example.f1vision.data.api.driverApi

import com.example.f1vision.data.database.driver.DriverEntity
import com.google.gson.annotations.SerializedName

typealias Root = List<DriverApiModel>

data class DriverApiModel (
    @SerializedName("session_key")
    val sessionKey: Long,
    @SerializedName("meeting_key")
    val meetingKey: Long,
    @SerializedName("broadcast_name")
    val broadcastName: String,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("headshot_url")
    val headshotUrl: String?,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("driver_number")
    val driverNumber: Long,
    @SerializedName("team_colour")
    val teamColour: String?,
    @SerializedName("team_name")
    val teamName: String,
    @SerializedName("name_acronym")
    val nameAcronym: String,
)

fun List<DriverApiModel>.asEntityModelList(): List<DriverEntity> {
    return this.map {
        DriverEntity(
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
            it.nameAcronym,
        )
    }
}