package com.cafeconpalito.pruebadanieldos.ui.horoscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.cafeconpalito.pruebadanieldos.R
import com.cafeconpalito.pruebadanieldos.databinding.FragmentHoroscopeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    //Implemento el View Model
    //private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private val horoscopeViewModel: HoroscopeViewModel by viewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Inicializando Variables
        initUI()
    }

    private fun initUI() {
        initUIstate()
    }

    /**
     * Se encarga de lanzar la corrutina para estar pendiente de los cambios en el View Model
     */
    private fun initUIstate() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscope.collect()

            }
        }
    }


}