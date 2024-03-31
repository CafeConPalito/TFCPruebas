package com.cafeconpalito.pruebadanieldos.domain

import com.cafeconpalito.pruebadanieldos.domain.model.PredictionModel

interface Repository {

    /**
     * Puede devolver un Prediction Response NULL
     */
    suspend fun getPrediction(sing:String): PredictionModel?
}