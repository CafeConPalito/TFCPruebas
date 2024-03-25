package com.cafeconpalito.pruebadanieldos.ui.palmistry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cafeconpalito.pruebadanieldos.R
import com.cafeconpalito.pruebadanieldos.databinding.FragmentLuckBinding
import com.cafeconpalito.pruebadanieldos.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    //Manera de trabajar con Binding y Fragmentos
    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Cargando el Binding para Un fragmento
        _binding = FragmentPalmistryBinding.inflate(inflater, container, false)
        return binding.root
    }

}