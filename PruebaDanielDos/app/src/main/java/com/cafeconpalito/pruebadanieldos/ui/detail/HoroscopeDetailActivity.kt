package com.cafeconpalito.pruebadanieldos.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.cafeconpalito.pruebadanieldos.R
import com.cafeconpalito.pruebadanieldos.databinding.ActivityHoroscopeDetailBinding
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding

    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    //Rescato los datos pasados por argumentos, el type de horoscopo.
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //El tipo de args!
        //args.type

        initUI()

        //Inicializo el Horoscopo a Mostrar
        //Saco de los args el typo y le paso el nombre, ya que son enumerados.
        horoscopeDetailViewModel.getHoroscope(args.type)

    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        //Deprecated creo que el siguiente funciona igual
        //binding.ivBack.setOnClickListener{onBackPressed()}
        binding.ivBack.setOnClickListener{onBackPressedDispatcher.onBackPressed()}
    }

    /**
     * Se ocupa en una corrutina de comprobar el estado del view model
     */
    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    //Siempre que cambien el estado hara lo siguiente
                    when (it) {
                        //it es la informacion del estado que puede contener informacion.
                        //Cada cambio de estado llama a su metodo
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState(it)
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun errorState(horoscopeDetailState: HoroscopeDetailState.Error) {
        binding.pb.isVisible = false
        binding.tvBody.text = horoscopeDetailState.error
    }

    private fun loadingState() {
        binding.pb.isVisible = true

    }


    private fun successState(horoscopeDetailState: HoroscopeDetailState.Success) {
        binding.pb.isVisible = false
        binding.tvDetailTitle.text = horoscopeDetailState.sing
        binding.tvBody.text = horoscopeDetailState.prediction

        //Segun el signo pondermos la imagen
        //Guardamos la variable en un int y podemos mostrarla
        val img =when(horoscopeDetailState.horoscopeModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(img)

    }

}
