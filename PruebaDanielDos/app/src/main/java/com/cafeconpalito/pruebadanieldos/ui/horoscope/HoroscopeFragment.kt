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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.cafeconpalito.pruebadanieldos.databinding.FragmentHoroscopeBinding
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo.*
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeModel
import com.cafeconpalito.pruebadanieldos.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    //Implemento el View Model
    //private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private val horoscopeViewModel: HoroscopeViewModel by viewModels()

    //Manera de trabajar con Binding y Fragmentos
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!


    //adapter para inicializar el RV
    private lateinit var horoscopeAdapter: HoroscopeAdapter

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
        initRecyclerView()
        initUIstate()
    }

    private fun initRecyclerView() {

        //Esta Controlando el Listener se se activa cambiara la vista
        horoscopeAdapter = HoroscopeAdapter(onItemSelectec = {

            //Obtengo el Horoscopo seleccionado
            val type =when (it) {
                Aquarius -> HoroscopeModel.Aquarius
                Aries -> HoroscopeModel.Aries
                Cancer -> HoroscopeModel.Cancer
                Capricorn -> HoroscopeModel.Capricorn
                Gemini -> HoroscopeModel.Gemini
                Leo -> HoroscopeModel.Leo
                Libra -> HoroscopeModel.Libra
                Pisces -> HoroscopeModel.Pisces
                Sagittarius -> HoroscopeModel.Sagittarius
                Scorpio -> HoroscopeModel.Scorpio
                Taurus -> HoroscopeModel.Taurus
                Virgo -> HoroscopeModel.Virgo
            }
            //Pasare el type utilizando el navigation.

            //Como estamos utilizando Fragments, Navigation y SafeArgs podemos utilizar estos metodos
            findNavController().navigate(
                //Tengo para la Clase una de Direcciones, puedo llega al ID de la navegacion!
                        HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity (type)
            )

        })


        binding.rvHoroscope.apply {

            //Layout Linear
            //layoutManager = LinearLayoutManager(context)

            //Layout Tipo Grid, necesita el nº de columnas
            layoutManager = GridLayoutManager(context, 2)

            adapter = horoscopeAdapter
        }

        /*
        Es lo mismo si aplico varias cosas al mismo binding lo meto dentro
        binding.rvHoroscope.layoutManager = LinearLayoutManager(context)
        binding.rvHoroscope.adapter =adapter
         */

    }

    /**
     * Se encarga de lanzar la corrutina para estar pendiente de los cambios en el View Model
     */
    private fun initUIstate() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    //Cargo la lista nueva con los datos de la lista
                    // "it" tiene los datos de la lista!!!!
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }


}