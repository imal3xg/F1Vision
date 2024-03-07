package com.example.f1vision.data.repository

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Circuit(
    val meetingName: String,
    val meetingOfficialName: String,
    val location: String,
    val countryKey: Long,
    val countryCode: String,
    val countryName: String,
    val circuitKey: Long,
    val dateStart: String,
    val meetingKey: Long,
    val year: Long,
) : Parcelable
