package com.cafeconpalito.pruebaramiro.apicons

import com.google.gson.annotations.SerializedName

data class RMDataResponse(@SerializedName("results") val results: List<RMCharactersResponse>)

data class RMCharactersResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
)
