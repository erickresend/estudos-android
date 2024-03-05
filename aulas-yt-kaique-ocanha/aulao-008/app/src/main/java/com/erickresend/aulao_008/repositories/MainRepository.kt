package com.erickresend.aulao_008.repositories

import com.erickresend.aulao_008.rest.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    // Esse repository é criado como boa pratica para caso mude a implementação da chamada a api
    //não tenha que mudar tudo no código, basta mudar aqui
    fun getAllLives() = retrofitService.getAllLives()
}