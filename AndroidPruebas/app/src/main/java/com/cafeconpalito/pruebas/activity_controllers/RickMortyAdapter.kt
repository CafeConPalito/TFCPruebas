package com.cafeconpalito.pruebas.activity_controllers

import Characters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebas.R


class RickMortyAdapter (private val characters:List<Characters>, private val onItemDone:(Int)-> Unit):
    RecyclerView.Adapter<RickMortyViewHolder>(){



    /**
     * Se ocupa de decir donde esta la vista "ITEM" (XML) para poder generarla y la devuelve.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickMortyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return RickMortyViewHolder(layoutInflater.inflate(R.layout.item_rick_morty,parent,false))
    }

    /**
     * Devuelve el numero de objetos de la lista.
     */
    override fun getItemCount(): Int = characters.size

    /**
     * Se ocupa de generar la vista de del TaskViewHolder a medida que las necesita,
     * Para ello llama al metodo render.
     * El cual recibe un String con el texto de la Tarea, lo saca de la lista de TaskS
     */
    override fun onBindViewHolder(holder: RickMortyViewHolder, position: Int) {
       holder.render(characters[position],onItemDone)
    }



}