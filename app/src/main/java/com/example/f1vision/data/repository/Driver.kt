package com.example.f1vision.data.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Driver(
    val sessionKey: Long,
    val meetingKey: Long,
    val broadcastName: String,
    val countryCode: String,
    val firstName: String,
    val fullName: String,
    val headshotUrl: String?,
    val lastName: String,
    val driverNumber: Long,
    val teamColour: String?,
    val teamName: String,
    val nameAcronym: String
) : Parcelable