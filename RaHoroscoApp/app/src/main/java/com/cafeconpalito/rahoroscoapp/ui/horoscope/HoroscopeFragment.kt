package com.cafeconpalito.rahoroscoapp.ui.horoscope

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafeconpalito.rahoroscoapp.databinding.FragmentHoroscopeBinding
import com.cafeconpalito.rahoroscoapp.ui.horoscope.adapter.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()
    private lateinit var horoscopeAdapter: HoroscopeAdapter
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            Toast.makeText(context, getString(it.name), Toast.LENGTH_LONG).show()
        })
        binding.rvHoroscope.apply {
            adapter = horoscopeAdapter
            layoutManager = GridLayoutManager(context,2)
        }
    }
    /*horoscopeAdapter = HoroscopeAdapter(onItemselected = {
        val type = when (it) {
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

        findNavController().navigate(
            HoroscopeFragmentDirections.actionHoroscopeFragmentToHoroscopeDetailActivity(type)
        )
    })

}*/

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeViewModel.horoscope.collect {
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopeBinding.inflate(inflater, container, false)
        return binding.root
    }

}

