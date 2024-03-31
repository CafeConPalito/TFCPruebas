package com.cafeconpalito.rahoroscoapp.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cafeconpalito.rahoroscoapp.databinding.ItemHoroscopeBinding
import com.cafeconpalito.rahoroscoapp.domain.model.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo){
        val context = binding.tvTittle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTittle.text = context.getString(horoscopeInfo.name)
    }
}