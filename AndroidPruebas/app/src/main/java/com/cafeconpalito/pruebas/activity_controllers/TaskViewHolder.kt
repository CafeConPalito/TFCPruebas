package com.cafeconpalito.pruebas.activity_controllers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebas.databinding.ItemTaskBinding


/**
 * COMPONENTE PERSONALIZADO
 * CONTROLLER de las vistas de las tareas
 * Necesita un Adapter para que recycler view pueda trabajar con el
 */
class TaskViewHolder(view:View): RecyclerView.ViewHolder(view) {

    private val binding = ItemTaskBinding.bind(view)

    //private val tvTaskName:TextView = view.findViewById(R.id.tvTasksName)

    //private val ivTaskDone:ImageView = view.findViewById(R.id.ivTaskDone)

    //se ocupa de setear el texto de la tareas!
    //On ItemDone Borra La tarea, esta recibe como un Int la posicion de la lista (ID)
    fun render(taskName:String, onItemDone:(Int) -> Unit){
        binding.tvTasksName.text = taskName
        binding.ivTaskDone.setOnClickListener { onItemDone(adapterPosition) }
    }



}