package com.erickresend.secao_31_convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.erickresend.secao_31_convidados.model.GuestModel
import com.erickresend.secao_31_convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    fun insert(guest: GuestModel) {
        //Mandar o que foi pego da activity e mandando para o repositorio, não teve nenhuma regra de negocio
        repository.insert(guest)
    }
}