package com.cafeconpalito.pruebaramiro.apicons

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebaramiro.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class RMViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemCharacterBinding.bind(view)

    fun bind(
        character: RMCharactersResponse, onItemSelected: (Int) -> Unit) {
        binding.tvCharacterName.text = character.name
        Picasso.get().load(character.image).into(binding.ivCharacterImage)
        binding.root.setOnClickListener {onItemSelected(character.id)
        }

    }
}