package com.cafeconpalito.pruebadanieldos.domain.model

import java.util.Date

data class Comment(
    val user: String,
    val comment: String,
    val date: Date
)
