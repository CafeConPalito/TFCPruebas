package com.cafeconpalito.pruebaramiro

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val tvTaskText: TextView = view.findViewById(R.id.tvTaskText)
    private val tvTaskDone: ImageView = view.findViewById(R.id.ivCheck)
    fun render(taskName:String, onItemDone:(Int) -> Unit){
        tvTaskText.text = taskName
        tvTaskDone.setOnClickListener { onItemDone(adapterPosition) }
    }

}