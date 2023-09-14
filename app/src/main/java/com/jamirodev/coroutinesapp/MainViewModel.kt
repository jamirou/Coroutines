package com.jamirodev.coroutinesapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")

    fun fetchData() {
        viewModelScope.launch {
            apiCall()
        }
    }

    private suspend fun apiCall() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            "Api response"
        }
        resultState = result
    }


    fun blockApp() {
        Thread.sleep(5000)
        resultState = "Api response"
    }
}