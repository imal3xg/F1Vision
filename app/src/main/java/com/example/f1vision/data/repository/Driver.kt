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
    val lastName: String,
    val fullName: String,
    val headshotUrl: String,
    val driverId: Long,
    val nameAcronym: String,
    val teamName: String,
    val teamColour: String,
) : Parcelable