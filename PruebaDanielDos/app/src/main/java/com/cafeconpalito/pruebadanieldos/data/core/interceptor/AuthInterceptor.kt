package com.cafeconpalito.pruebadanieldos.data.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val tokenManager: TokenManager): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //Modifica la Requeste de la peticion a la API para añadir informacion a esta .newBuilder
        //se le puede añadir Auth
        /*
        val request = chain.request().newBuilder()
            .header("Autorization","¡¡¡¡mi Auth!!!!")
            .build()
        */

        //Lo mismo que arriba pero con injeccion de dependencias
        val request = chain.request().newBuilder()
            .header("Autorization",tokenManager.getToken())
            .build()

        return chain.proceed(request)
    }
}