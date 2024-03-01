package com.erickresend.retrofit_canal_mobilizando.api

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

//Interface de consulta do retrofit
interface Endpoint {
    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies.json")
    fun getCurrencies(): Call<JsonObject>

    @GET("/gh/fawazahmed0/currency-api@1/latest/currencies/{from}/{to}.json")
    fun getCurrencyRate(
        @Path(value = "from", encoded = true) from: String,
        @Path(value = "to", encoded = true) to: String
    ): Call<JsonObject>
}