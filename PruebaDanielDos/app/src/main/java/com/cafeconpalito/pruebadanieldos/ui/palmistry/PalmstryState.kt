package com.cafeconpalito.pruebadanieldos.ui.palmistry

import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeModel
import com.cafeconpalito.pruebadanieldos.ui.detail.HoroscopeDetailState

sealed class PalmstryState {

    data object Loading: PalmstryState()
    data class Error(val error:String): PalmstryState()
    data class Success(val apiKey:String): PalmstryState()

}