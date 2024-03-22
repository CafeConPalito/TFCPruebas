package com.cafeconpalito.pruebas

import android.app.Application
import com.cafeconpalito.pruebas.preferences.Preferences

/**
 * OJO AÑADIRLO AL MANIFEST!!!!!!
 *
 *
 * La primera clase por la que pasa el proyecto antes de empezar.
 * se utiliza para instanciar o cargar cosas que necesitas antes de que arranque.
 *
 */
class TaskApplication:Application() {
    /**
     * Static
     * para poder acceder a la variable desde la app se mete dentro del companion object
     */
    companion object{
        lateinit var prefs: Preferences
    }
    override fun onCreate() {
        super.onCreate()
        //se le pasa un contexto en este caso el baseContext que es el contexto general
        prefs = Preferences(baseContext)
    }

}