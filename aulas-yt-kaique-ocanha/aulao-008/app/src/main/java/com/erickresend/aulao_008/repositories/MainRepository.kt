package com.erickresend.aulao_008.repositories

import com.erickresend.aulao_008.rest.RetrofitKotlin

class MainRepository constructor(private val retrofitKotlin: RetrofitKotlin) {

    fun getAllLives() = retrofitKotlin.getAllLives()
}