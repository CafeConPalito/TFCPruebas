package com.cafeconpalito.pruebadanieldos.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.pruebadanieldos.R
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo

/**
 * On item Selected en este caso le paso toda la info del HoroscopeInfo
 */
class HoroscopeAdapter(
    private var horoscopeList: List<HoroscopeInfo> = emptyList(),
    private val onItemSelectec: (HoroscopeInfo) -> Unit
) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    /**
     * Como no recibia una lista y esta lista no cambia se la paso luego
     */
    fun updateList(list: List<HoroscopeInfo>) {
        horoscopeList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false)
        )
    }

    override fun getItemCount(): Int = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position], onItemSelectec)
    }


}