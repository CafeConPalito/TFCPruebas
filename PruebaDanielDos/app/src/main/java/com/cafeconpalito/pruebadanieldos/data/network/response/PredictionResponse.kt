package com.cafeconpalito.pruebadanieldos.data.network.response

import com.cafeconpalito.pruebadanieldos.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

/**
https://jsoneditoronline.org/
https://json2kt.com/
 */
data class PredictionResponse(
    @SerializedName("date") var date: String,
    @SerializedName("horoscope") var horoscope: String,
    //@SerializedName("icon"      ) var icon      : String? = null,
    //@SerializedName("id"        ) var id        : Int?    = null,
    @SerializedName("sign") var sign: String
) {

    /**
     * Se ocupa de transformar los datos de PredictionResponse a PredictionModel
     */
    fun toDomain(): PredictionModel {
        //Construyo y devuelvo el Objeto
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }

}
