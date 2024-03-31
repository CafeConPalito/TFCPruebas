package com.cafeconpalito.pruebadanieldos.data

import android.util.Log
import com.cafeconpalito.pruebadanieldos.data.network.HoroscopeApiService
import com.cafeconpalito.pruebadanieldos.data.network.response.PredictionResponse
import com.cafeconpalito.pruebadanieldos.domain.Repository
import com.cafeconpalito.pruebadanieldos.domain.model.PredictionModel
import javax.inject.Inject

/**
 * Se ocupa de la logica para enviar los datos.
 * con injeccion de dependencias obtenesmo el apiService con la conexion establecida y las implementaciones necesarias.
 * SI DA ERROR DEVUELVE UN Prediccion Response NULL
 */
class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService): Repository {

    /**
     * Para cambiar un modelo de tipo se utiliza el mapeo.
     * Get Prediction nos da un PredictionResponse (con anotaciones)
     * Lo convertimos a PredictionModel
     */
    override suspend fun getPrediction(sing: String): PredictionModel? {
        //Lanza la tarea
        runCatching {
            apiService.getPrediction(sing)
        }
            //si es ok hace lo siguiente.
            //Utilizando la funcion toDomain que se encuentra en PredictionResponose pasa el objeto correcto
            .onSuccess {  return it.toDomain() }
            //si es error guarda un log y luego retorno el null
            .onFailure { Log.i("getPrediction" , "Ocurrio un error: ${it.message}") }

        //si falla retorna un objeto null
        return null
    }
}