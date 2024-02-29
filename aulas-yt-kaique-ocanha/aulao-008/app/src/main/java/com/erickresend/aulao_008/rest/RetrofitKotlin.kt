package com.erickresend.aulao_008.rest

import com.erickresend.aulao_008.models.Live
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitKotlin {

    @GET("lista-lives.json")
    fun getAllLives(): Call<List<Live>>

    companion object {
        private val retrofitService: RetrofitKotlin by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://s3.amazonaws.com/api.ocanha.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitKotlin::class.java)
        }
    }

    fun getIntence(): RetrofitKotlin {
        return retrofitService
    }
}