package com.cafeconpalito.pruebas

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


/**
 * COMPONENTE PERSONALIZADO
 * CONTROLLER de las vistas de las tareas
 * Necesita un Adapter para que recycler view pueda trabajar con el
 */
class TaskViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val tvTaskName:TextView = view.findViewById(R.id.tvTasksName)

    private val ivTaskDone:ImageView = view.findViewById(R.id.ivTaskDone)

    //se ocupa de setear el texto de la tareas!
    //On ItemDone Borra La tarea, esta recibe como un Int la posicion de la lista (ID)
    fun render(taskName:String, onItemDone:(Int) -> Unit){
        tvTaskName.text = taskName
        ivTaskDone.setOnClickListener { onItemDone(adapterPosition) }
    }



}