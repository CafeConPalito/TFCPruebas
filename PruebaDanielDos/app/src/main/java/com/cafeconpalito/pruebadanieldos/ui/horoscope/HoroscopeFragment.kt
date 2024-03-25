package com.cafeconpalito.pruebadanieldos.ui.horoscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cafeconpalito.pruebadanieldos.R
import com.cafeconpalito.pruebadanieldos.databinding.FragmentHoroscopeBinding

class HoroscopeFragment : Fragment() {

    //Manera de trabajar con Binding y Fragmentos
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Cargando el Binding para Un fragmento
        _binding = FragmentHoroscopeBinding.inflate(inflater, container, false)
        return binding.root
    }


}