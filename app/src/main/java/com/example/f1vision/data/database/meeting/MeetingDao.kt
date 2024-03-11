package com.example.f1vision.data.database.meeting

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MeetingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createMeeting(listMeetingEntity: List<MeetingEntity>)

    @Query("SELECT * FROM meeting")
    fun getAllMeetings(): Flow<List<MeetingEntity>>
}