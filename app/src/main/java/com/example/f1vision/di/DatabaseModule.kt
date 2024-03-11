package com.example.f1vision.di

import android.content.Context
import com.example.f1vision.data.database.F1VisionDatabase
import com.example.f1vision.data.database.driver.DriverDao
import com.example.f1vision.data.database.meeting.MeetingDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object DatabaseModule {
    @Singleton
    @Provides
    fun provideF1VisionDatabase(@ApplicationContext context: Context): F1VisionDatabase {
        return F1VisionDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideMeetingDao(database: F1VisionDatabase): MeetingDao {
        return database.meetingDao()
    }

    @Singleton
    @Provides
    fun provideDriverDao(database: F1VisionDatabase): DriverDao {
        return database.driverDao()
    }
}