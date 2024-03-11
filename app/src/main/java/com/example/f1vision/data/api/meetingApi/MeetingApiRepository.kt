package com.example.f1vision.data.api.meetingApi

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MeetingApiRepository @Inject constructor(private val service: MeetingApi) {
    suspend fun getAllMeetings(): List<MeetingApiModel> {
        // Creamos una lista mutable donde almacenaremos los detalles de los circuitos
        val meetingsWithDetails = mutableListOf<MeetingApiModel>()
        // Intentamos obtener la lista básica de circuitos
        try {
            // Llamamos a la función getAllMeetings() de la interfaz MeetingApi
            val simpleList = service.getAllMeetings()
            // Agregamos el circuito obtenido a la lista de detalles
            meetingsWithDetails.add(simpleList)
        } catch (e: Exception) {
            // Si ocurre algún error al obtener la lista básica de circuitos, registramos el error y devolvemos una lista vacía
            Log.e("Error", "Error al obtener la lista de circuitos", e)
            return emptyList()
        }
        // Iteramos sobre cada circuito obtenido para obtener sus detalles
        for (meeting in meetingsWithDetails) {
            try {
                // Llamamos a la función getDetailMeeting() de la interfaz MeetingApi para obtener los detalles del circuito
                val response = service.getDetailMeeting(meeting.meetingKey)
                // Agregamos los detalles del circuito a la lista de detalles
                meetingsWithDetails.add(response)
            } catch (e: Exception) {
                // Si ocurre algún error al obtener los detalles del circuito, registramos el error
                Log.e("Error", "Error al obtener detalles del circuito para el número ${meeting.meetingKey}", e)
            }
        }
        // Devolvemos la lista completa de detalles de los circuitos
        return meetingsWithDetails
    }
}