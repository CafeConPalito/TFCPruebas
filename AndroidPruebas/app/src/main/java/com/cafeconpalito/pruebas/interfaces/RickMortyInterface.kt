package com.cafeconpalito.pruebas.interfaces

import RMResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickMortyInterface {

    //private val apiKey:String = "368a2c3972ac688901ed04880a242d5f"
    @GET("character/")
    suspend fun getByName(@Query("name") name: String): Response<RMResponse>

}