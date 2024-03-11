package com.example.f1vision.data.database

import androidx.annotation.WorkerThread
import com.example.f1vision.data.database.driver.DriverDao
import com.example.f1vision.data.database.driver.DriverEntity
import com.example.f1vision.data.database.meeting.MeetingDao
import com.example.f1vision.data.database.meeting.MeetingEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class F1VisionDBRepository @Inject constructor(private val driverDao: DriverDao, private val meetingDao: MeetingDao) {
    val allDrivers: Flow<List<DriverEntity>> = driverDao.getAllDrivers()
    val allMeetings: Flow<List<MeetingEntity>> = meetingDao.getAllMeetings()

    @WorkerThread
    suspend fun insert(listDriverEntity: List<DriverEntity>) {
        driverDao.createDriver(listDriverEntity)
    }

    @WorkerThread
    suspend fun insertt(listMeetingEntity: List<MeetingEntity>) {
        meetingDao.createMeeting(listMeetingEntity)
    }

    suspend fun getAllDrivers(): Flow<List<DriverEntity>> {
        return driverDao.getAllDrivers()
    }
}
