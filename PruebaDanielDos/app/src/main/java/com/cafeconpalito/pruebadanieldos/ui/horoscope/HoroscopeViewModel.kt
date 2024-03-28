package com.cafeconpalito.pruebadanieldos.ui.horoscope

import androidx.lifecycle.ViewModel
import com.cafeconpalito.pruebadanieldos.data.providers.HoroscopeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo.*

/**
 * a la clase en el injector de de pendencias le pido un horoscopeProvider,
 * Este es el que me enviara la lista con los signos del horoscopo.
 */
@HiltViewModel
class HoroscopeViewModel @Inject constructor(private val horoscopeProvider: HoroscopeProvider) : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        //Le paso las lista de horoscopos
        _horoscope.value = horoscopeProvider.getHoroscopes()
    }

}