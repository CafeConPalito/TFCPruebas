package com.cafeconpalito.pruebadanieldos.domain

import com.cafeconpalito.pruebadanieldos.domain.model.ChickModel
import com.cafeconpalito.pruebadanieldos.domain.model.PredictionModel

interface Repository {

    /**
     * Puede devolver un Prediction Response NULL
     */
    suspend fun getPrediction(sing:String): PredictionModel?

    suspend fun getLogin(user:String,password:String):String?

    suspend fun getChiksTop():List<ChickModel>?

}