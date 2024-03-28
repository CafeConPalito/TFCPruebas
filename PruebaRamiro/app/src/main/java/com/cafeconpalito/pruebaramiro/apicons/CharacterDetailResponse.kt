package com.cafeconpalito.pruebaramiro.apicons

import com.google.gson.annotations.SerializedName

data class CharacterDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("image") val image: String,
)
