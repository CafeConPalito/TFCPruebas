package com.cafeconpalito.pruebas.interfaces

import com.cafeconpalito.pruebas.entities.Comic
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicInterface {
        @GET("{idComic}/info.0.json")
        suspend fun getComic(@Path("idComic") idComic: Int): Response<Comic>

}
