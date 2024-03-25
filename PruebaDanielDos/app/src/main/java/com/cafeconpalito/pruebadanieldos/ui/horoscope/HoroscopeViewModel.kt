package com.cafeconpalito.pruebadanieldos.ui.horoscope

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeInfo.*

@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = listOf(Aries,Gemini,Taurus)
    }

}