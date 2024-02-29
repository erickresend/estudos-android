package com.erickresend.aulao_008.viewmodel.main

import androidx.lifecycle.ViewModel
import com.erickresend.aulao_008.repositories.MainRepository

class MainViewModel constructor(private val repository: MainRepository): ViewModel() {

    val request = repository.getAllLives()
        .isExecuted.
}