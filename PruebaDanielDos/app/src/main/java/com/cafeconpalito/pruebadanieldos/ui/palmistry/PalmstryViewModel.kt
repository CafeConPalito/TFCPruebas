package com.cafeconpalito.pruebadanieldos.ui.palmistry

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cafeconpalito.pruebadanieldos.domain.usecase.GetLogin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PalmstryViewModel @Inject constructor(private val getLogin: GetLogin) : ViewModel() {


    //Como valor inicial le paso el estado de Cargando
    private var _state = MutableStateFlow<PalmstryState>(PalmstryState.Loading)
    //devuelve el estado en el que se encuentra, por eso no es publica
    val state: StateFlow<PalmstryState> = _state

    fun tryLogin(user: String, password: String){


        //Esta trabajando en el Hilo principal
        viewModelScope.launch {
            //HILO PRINCIPAL

            //Cambio el stado a loading.
            _state.value = PalmstryState.Loading

            //Esto lanza un hilo secundario, almaceno la respuesta en result
            val result = withContext(Dispatchers.IO){
                // VER LA CLASE GET PREDICTION
                // al usar la palabra "operator" en la funcion a la clase directamente y tratarla como una funcion accede a esta
                getLogin(user,password)
            }

            //HILO PRINCIPAL

            //si la respuesta es correcta
            if (result!=null){
                //Paso el esdado a Success y le paso el texto del horoscopo
                //SE PUEDE DEVOLVER EL OBJETO ENTERO O LO QUE NECESITEMOS.
                _state.value = PalmstryState.Success(result.toString())
            } else{
                _state.value = PalmstryState.Error("No me logro conectar")
            }

        }
    }





}