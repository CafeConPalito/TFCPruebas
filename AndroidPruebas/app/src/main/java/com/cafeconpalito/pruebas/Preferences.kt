package com.cafeconpalito.pruebas

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    /**
     * Los statics de Java!
     */
    companion object {
        //Nombre con el que se guardan las preferencias (imagino que el Binario)
        const val PREFS_NAME = "myDatabase"
        //Nombre de la Clave Valor que utiliza las preff para guardar la info
        const val TASKS = "tasks_value"
    }

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)

    fun saveTasks(tasks:List<String>){
        //Guarda un par de Clave Valor.
        prefs.edit().putStringSet(TASKS, tasks.toSet()).apply()
    }

    fun getTasks():MutableList<String>{
        return prefs.getStringSet(TASKS, emptySet<String>())?.toMutableList() ?: mutableListOf()
    }
}