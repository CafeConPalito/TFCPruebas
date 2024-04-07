package com.cafeconpalito.pruebadanieldos.domain.model

import java.util.Date

data class ChickModel (

    val title: String,
    val author: String,
    val date: Date,
    val likes: Int,
    val status: String,
    val content: List<ContentItem>,
    val comments: List<Comment>,
    val mentions: List<String>

)
