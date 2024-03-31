package com.cafeconpalito.pruebadanieldos.data.network

import com.cafeconpalito.pruebadanieldos.BuildConfig.BASE_URL
import com.cafeconpalito.pruebadanieldos.data.RepositoryImpl
import com.cafeconpalito.pruebadanieldos.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Tiene la conexion a la API utilizando retrofit
 * Tipo de objeto SINGELTON :D
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * SINGELTON
     * Crea la conexion necesaria a la API
     * Recibe como parametro un interceptor para obtener la informacion de la consulta.
     *
     * BASE_URL VIENE DEL GRADEL, POR EL TIPO DE CONFIGURACION!
     */
    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    /**
     * Interceptor se utilizan para obtener toda la respuesta de la Red,
     * La guarda en el LOG permite ver que pasa con las llamadas
     * Segun el nivel podemos obtener mas o menos info
     */
    @Provides
    @Singleton
    fun providesOkHttpClient():OkHttpClient{
        //Este nivel de interceptor captura toda la respuesda de la Api
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()
    }

    /**
     * Construye el repositorio de API SERVICE
     */
    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{
        return retrofit.create(HoroscopeApiService::class.java)
    }

    /**
     *
     * Para difenrecioar entre repositorios utilizamos la Notacion @Name
     */
    //@Named
    @Provides
    fun provideRepository(apiService: HoroscopeApiService):Repository {
        return RepositoryImpl(apiService)
    }

}