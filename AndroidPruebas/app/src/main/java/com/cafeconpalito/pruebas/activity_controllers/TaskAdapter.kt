package com.cafeconpalito.pruebas.activity_controllers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebas.R

/**
 * Adapter se ocupa de controlar las ViewHolder (TaskViewHolder)
 * Recibe el item done pasado desde el Main
 */
//Para operar con tasks, la lista de tareas, private val!
class TaskAdapter(private val tasks:List<String>,private val onItemDone:(Int)-> Unit):RecyclerView.Adapter<TaskViewHolder>() {

    /**
     * Devuelve el numero de objetos de la lista.
     */
    override fun getItemCount(): Int {
        return tasks.size
    }

    /**
     * Se ocupa de generar la vista de del TaskViewHolder a medida que las necesita,
     * Para ello llama al metodo render.
     * El cual recibe un String con el texto de la Tarea, lo saca de la lista de TaskS
     */
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(tasks[position], onItemDone)
    }
    
    /**
     * Se ocupa de decir donde esta la vista (XML) para poder generarla y la devuelve.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater:LayoutInflater = LayoutInflater.from(parent.context)
        return TaskViewHolder(layoutInflater.inflate(R.layout.item_task,parent,false))
    }

}