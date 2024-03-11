package com.example.f1vision.data.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meeting(
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
) : Parcelable
