package com.cafeconpalito.pruebas.services

import android.util.Log
import com.cafeconpalito.pruebas.conections.RetrofitBuilderComic
import com.cafeconpalito.pruebas.entities.Comic
import com.cafeconpalito.pruebas.interfaces.ComicInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComicService {

    private val retrofit = RetrofitBuilderComic.build()

    suspend fun getComic(idComic:Int) : Comic {
        return withContext(Dispatchers.IO) { //Esto lanza la corrutina en otro hilo para poder llamarla sin problemas :D
            val response = retrofit.create(ComicInterface::class.java).getComic(idComic)
            Log.i("PruebasComic",response.body().toString())
            response.body() ?: Comic()
        }
    }





}