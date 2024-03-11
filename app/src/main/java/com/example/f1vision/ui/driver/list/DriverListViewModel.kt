package com.example.f1vision.ui.driver.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1vision.data.repository.F1VisionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DriverListViewModel @Inject constructor(private val repository: F1VisionRepository): ViewModel() {
    private val _uiState = MutableStateFlow(DriverListUiState(listOf()))
    val uiState: StateFlow<DriverListUiState>
        get() = _uiState.asStateFlow()
    init {
        viewModelScope.launch {
            try {
                repository.refreshList()
            } catch (e: IOException) {
                Log.e("ERROR", e.toString())
            }
        }
        viewModelScope.launch {
            repository.allDrivers.collect {
                _uiState.value = DriverListUiState(it)
            }
        }
    }
}