package com.jamirodev.coroutinesapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")


    fun blockApp() {
        Thread.sleep(5000)
        resultState = "Api response"
    }
}