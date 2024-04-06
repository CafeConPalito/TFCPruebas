package com.cafeconpalito.pruebadanieldos.data.network

import com.cafeconpalito.pruebadanieldos.data.network.response.PredictionResponse
import com.cafeconpalito.pruebadanieldos.domain.model.ChickModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HoroscopeApiService {

    @GET("/{sing}/")
    suspend fun getPrediction(@Path("sing") sing:String):PredictionResponse

    @GET("/api/v1/users/login")
    suspend fun getLogin(@Query("user") user:String, @Query("password") password:String):String

    @GET("/api/v1/chiks/top")
    suspend fun getChiksTop():List<ChickModel>

}