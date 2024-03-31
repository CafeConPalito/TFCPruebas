package com.cafeconpalito.pruebadanieldos.ui.detail

import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeModel


/**
 * Lo utiliza el ViewModel
 * Se ocupa de gestionar el estado de la vista e informar si esta cargando, es erro o tiene info.
 */
sealed class HoroscopeDetailState {
    data object Loading:HoroscopeDetailState()
    data class Error(val error:String):HoroscopeDetailState()
    data class Success(val prediction: String, val sing: String, val horoscopeModel: HoroscopeModel):HoroscopeDetailState()
}