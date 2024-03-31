package com.cafeconpalito.rahoroscoapp.ui.horoscope.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.rahoroscoapp.R
import com.cafeconpalito.rahoroscoapp.domain.model.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList()) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    fun updateList(list:List<HoroscopeInfo>){
        horoscopeList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(
            LayoutInflater.from (parent.context).inflate(R.layout.item_horoscope, parent, false))
    }

    override fun getItemCount(): Int = horoscopeList.size

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(horoscopeList[position])
    }

}