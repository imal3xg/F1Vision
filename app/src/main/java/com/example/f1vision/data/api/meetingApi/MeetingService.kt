package com.example.f1vision.data.api.meetingApi

import com.example.f1vision.data.api.driverApi.DriverApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

interface MeetingApi {
    @GET("v1/meetings?year=2023")
    suspend fun getAllMeetings(): MeetingApiModel

    @GET("v1/meetings?year=2023&meeting_key={meeting_key}")
    suspend fun getDetailMeeting(@Path("meeting_key") meetingKey: Long): MeetingApiModel
}

@Singleton
class MeetingService @Inject constructor(){
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openf1.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api: MeetingApi = retrofit.create(MeetingApi::class.java)
}