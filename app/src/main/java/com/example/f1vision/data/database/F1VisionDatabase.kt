package com.example.f1vision.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.f1vision.data.database.driver.DriverDao
import com.example.f1vision.data.database.driver.DriverEntity
import com.example.f1vision.data.database.meeting.MeetingDao
import com.example.f1vision.data.database.meeting.MeetingEntity

@Database(entities = [DriverEntity::class, MeetingEntity::class], version = 2)
abstract class F1VisionDatabase : RoomDatabase() {

    abstract fun driverDao(): DriverDao

    abstract fun meetingDao(): MeetingDao

    companion object {
        @Volatile
        private var INSTANCE: F1VisionDatabase? = null

        fun getInstance(context: Context): F1VisionDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }
        }

        private fun buildDatabase(context: Context): F1VisionDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                F1VisionDatabase::class.java,
                "f1vision_db"
            ).fallbackToDestructiveMigration().build()
        }
    }
}