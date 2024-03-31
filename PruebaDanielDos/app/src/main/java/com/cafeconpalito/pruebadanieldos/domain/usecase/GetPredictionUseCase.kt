package com.cafeconpalito.pruebadanieldos.domain.usecase

import com.cafeconpalito.pruebadanieldos.domain.Repository
import javax.inject.Inject


/**
 *
 */
class GetPredictionUseCase @Inject constructor(private val repository: Repository) {

    /**
     * al usar la palabra "operator" al llamar a la clase directamente si le pongo parentecis estoy llamando a este metodo!
     *
     * Retorna el PredictionModel
     */
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)


}