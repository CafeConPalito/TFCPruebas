package com.cafeconpalito.pruebadanieldos.data.core.interceptor

import javax.inject.Inject

class TokenManager @Inject constructor() {


    fun getToken():String = "mi Token Auth"

}