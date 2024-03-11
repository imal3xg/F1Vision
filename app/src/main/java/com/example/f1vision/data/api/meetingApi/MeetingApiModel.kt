package com.example.f1vision.data.api.meetingApi

import com.example.f1vision.data.database.meeting.MeetingEntity
import com.google.gson.annotations.SerializedName

typealias Root = List<MeetingApiModel>

data class MeetingApiModel(
    @SerializedName("circuit_key")
    val circuitKey: Long,
    @SerializedName("circuit_short_name")
    val circuitShortName: String,
    @SerializedName("meeting_key")
    val meetingKey: Long,
    @SerializedName("meeting_code")
    val meetingCode: String,
    val location: String,
    @SerializedName("country_key")
    val countryKey: Long,
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("country_name")
    val countryName: String,
    @SerializedName("meeting_name")
    val meetingName: String,
    @SerializedName("meeting_official_name")
    val meetingOfficialName: String,
    @SerializedName("gmt_offset")
    val gmtOffset: String,
    @SerializedName("date_start")
    val dateStart: String,
    val year: Long,
)

fun List<MeetingApiModel>.asEntityModelList(): List<MeetingEntity> {
    return this.map {
        MeetingEntity(
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
            it.year
        )
    }
}