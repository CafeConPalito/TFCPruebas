package com.cafeconpalito.pruebas.services

import Characters
import android.util.Log
import com.cafeconpalito.pruebas.conections.RetrofitBuilderRickMorty
import com.cafeconpalito.pruebas.interfaces.RickMortyInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RickMortyService {

    private val retrofit = RetrofitBuilderRickMorty.build()
    suspend fun getByName(name:String) : List<Characters> {
        return withContext(Dispatchers.IO) { //Esto lanza la corrutina en otro hilo para poder llamarla sin problemas :D
            val response = retrofit.create(RickMortyInterface::class.java).getByName(name)

            Log.i("RickMortyResponse",response.body().toString())

            //devuelve datos si los hubiera, sino devuelve una lista vacia
            //Estoy pillando del Body solo lo que necesito en este caso los .results (Characters)
            response.body()?.results ?: emptyList()

        }
    }

}