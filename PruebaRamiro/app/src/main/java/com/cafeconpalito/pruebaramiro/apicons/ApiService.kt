package com.cafeconpalito.pruebaramiro.apicons

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character/")
    suspend fun getCharacters(@Query("name") name: String?): Response<RMDataResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int?): Response<CharacterDetailResponse>
}