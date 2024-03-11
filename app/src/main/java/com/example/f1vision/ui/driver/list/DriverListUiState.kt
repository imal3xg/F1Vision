package com.example.f1vision.ui.driver.list

import com.example.f1vision.data.repository.Driver

data class DriverListUiState(
    val driver: List<Driver>,
    val errorMessage: String?=null
)
