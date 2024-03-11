package com.example.f1vision.data.repository

import com.example.f1vision.data.api.driverApi.DriverApiRepository
import com.example.f1vision.data.api.driverApi.asEntityModelList
import com.example.f1vision.data.api.meetingApi.MeetingApiRepository
import com.example.f1vision.data.api.meetingApi.asEntityModelList
import com.example.f1vision.data.database.F1VisionDBRepository
import com.example.f1vision.data.database.driver.asListDriver
import com.example.f1vision.data.database.meeting.asListMeeting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class F1VisionRepository @Inject constructor(
    private val dbRepository: F1VisionDBRepository,
    private val driverRepository: DriverApiRepository,
    private val meetingRepository: MeetingApiRepository
) {
    val allDrivers: Flow<List<Driver>>
        get() = dbRepository.allDrivers.map {
            entities -> withContext(Dispatchers.Default) {
                entities.asListDriver()
            }
        }

    val allMeetings: Flow<List<Meeting>>
        get() = dbRepository.allMeetings.map {
            entities -> withContext(Dispatchers.Default) {
                entities.asListMeeting()
            }
        }

    suspend fun getAllDrivers(): Flow<List<Driver>> {
        return dbRepository.getAllDrivers().map { it.asListDriver() }
    }

    suspend fun refreshList() {
        withContext(Dispatchers.IO) {
            try {
                val apiDriver = driverRepository.getAllDrivers()
                val apiMeeting = meetingRepository.getAllMeetings()
                dbRepository.insert(apiDriver.asEntityModelList())
                dbRepository.insertt(apiMeeting.asEntityModelList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}