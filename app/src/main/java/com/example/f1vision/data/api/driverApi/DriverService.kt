package com.example.f1vision.data.api.driverApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

interface DriverApi {
    @GET("v1/drivers?session_key=latest")
    suspend fun getAllDrivers(): DriverApiModel

    @GET("v1/drivers?session_key=latest&driver_number={driver_number}")
    suspend fun getDetailDriver(@Path("driver_number") driverNumber: Long): DriverApiModel
}

@Singleton
class DriverService @Inject constructor(){
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openf1.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: DriverApi = retrofit.create(DriverApi::class.java)
}