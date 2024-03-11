package com.example.f1vision.data.database.driver

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DriverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createDriver(listDriverEntity: List<DriverEntity>)

    @Query("SELECT * FROM driver")
    fun getAllDrivers(): Flow<List<DriverEntity>>
}