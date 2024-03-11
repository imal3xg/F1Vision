package com.example.f1vision.data.api.driverApi

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DriverApiRepository @Inject constructor(private val service: DriverApi) {
    suspend fun getAllDrivers(): List<DriverApiModel> {
        // Creamos una lista mutable donde almacenaremos los detalles de los pilotos
        val driversWithDetails = mutableListOf<DriverApiModel>()
        // Intentamos obtener la lista básica de pilotos
        try {
            // Llamamos a la función getAllDrivers() de la interfaz DriverApi
            val simpleList = service.getAllDrivers()
            // Agregamos el piloto obtenido a la lista de detalles
            driversWithDetails.add(simpleList)
        } catch (e: Exception) {
            // Si ocurre algún error al obtener la lista básica de pilotos, registramos el error y devolvemos una lista vacía
            Log.e("Error", "Error al obtener la lista de pilotos", e)
            return emptyList()
        }
        // Iteramos sobre cada piloto obtenido para obtener sus detalles
        for (driver in driversWithDetails) {
            try {
                // Llamamos a la función getDetailDriver() de la interfaz DriverApi para obtener los detalles del piloto
                val response = service.getDetailDriver(driver.driverNumber)
                // Agregamos los detalles del piloto a la lista de detalles
                driversWithDetails.add(response)
            } catch (e: Exception) {
                // Si ocurre algún error al obtener los detalles del piloto, registramos el error
                Log.e("Error", "Error al obtener detalles del piloto para el número ${driver.driverNumber}", e)
            }
        }
        // Devolvemos la lista completa de detalles de los pilotos
        return driversWithDetails
    }
}