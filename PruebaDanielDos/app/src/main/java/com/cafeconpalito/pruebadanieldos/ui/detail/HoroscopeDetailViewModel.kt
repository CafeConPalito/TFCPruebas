package com.cafeconpalito.pruebadanieldos.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor() :ViewModel() {

    //Como valor inicial le paso el estado de Cargando
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    //devuelve el estado en el que se encuentra, por eso no es publica
    val state:StateFlow<HoroscopeDetailState> = _state

}