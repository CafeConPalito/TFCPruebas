package com.cafeconpalito.pruebadanieldos.data.network

import com.cafeconpalito.pruebadanieldos.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HoroscopeApiService {

    @GET("/{sing}/")
    suspend fun getPrediction(@Path("sing") sing:String):PredictionResponse
}