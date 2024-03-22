package com.cafeconpalito.pruebas.activity_controllers

import Characters
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebas.databinding.ItemRickMortyBinding
import com.squareup.picasso.Picasso

class RickMortyViewHolder(view: View): RecyclerView.ViewHolder(view) {


    private val binding = ItemRickMortyBinding.bind(view)
    fun render(character:Characters, onItemDone:(Int) -> Unit){
        binding.tvCharName.text = character.name.toString()
        //Picasso se ocupa de cargar la imagen en el Image View
        //Picasso.get().load(character.image.toString()).resize(binding.imCharImage.maxWidth,binding.imCharImage.maxHeight).into(binding.imCharImage)
        Picasso.get().load(character.image.toString()).into(binding.imCharImage)

    }




}