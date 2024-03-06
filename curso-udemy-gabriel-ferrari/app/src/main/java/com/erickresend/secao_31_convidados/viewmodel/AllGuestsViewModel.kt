package com.erickresend.secao_31_convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.erickresend.secao_31_convidados.model.GuestModel
import com.erickresend.secao_31_convidados.repository.GuestRepository

/*Criei o getInstance que é a instancia do repositorio, ele exige um parametro context
* para isso precisamos mudar o tipo da classe de ViewModel para AndroidViewModel*/
class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GuestRepository = GuestRepository.getInstance(application.applicationContext)
    private val listAllGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = listAllGuests

    fun getAll() {
        listAllGuests.value = repository.getAll()
    }
}