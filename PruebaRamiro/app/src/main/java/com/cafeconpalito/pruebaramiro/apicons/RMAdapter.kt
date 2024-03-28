package com.cafeconpalito.pruebaramiro.apicons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebaramiro.R

class RMAdapter(
    var characterList: List<RMCharactersResponse> = emptyList(),
    private val onItemSelected:(Int) -> Unit
) :
    RecyclerView.Adapter<RMViewHolder>() {

    fun updateList(characterList: List<RMCharactersResponse>) {
        this.characterList = characterList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RMViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return RMViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RMViewHolder, position: Int) {
        viewHolder.bind(characterList[position],onItemSelected)
    }

    override fun getItemCount(): Int = characterList.size


}