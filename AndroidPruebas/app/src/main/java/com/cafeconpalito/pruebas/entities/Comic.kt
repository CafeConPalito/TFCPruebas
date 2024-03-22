package com.cafeconpalito.pruebas.entities

import com.google.gson.annotations.SerializedName
data class Comic(

    @SerializedName("month"      ) var month      : String? = null,
    @SerializedName("num"        ) var num        : Int?    = null,
    @SerializedName("link"       ) var link       : String? = null,
    @SerializedName("year"       ) var year       : String? = null,
    @SerializedName("news"       ) var news       : String? = null,
    @SerializedName("safe_title" ) var safeTitle  : String? = null,
    @SerializedName("transcript" ) var transcript : String? = null,
    @SerializedName("alt"        ) var alt        : String? = null,
    @SerializedName("img"        ) var img        : String? = null,
    @SerializedName("title"      ) var title      : String? = null,
    @SerializedName("day"        ) var day        : String? = null

)
