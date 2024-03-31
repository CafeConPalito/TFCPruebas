package com.cafeconpalito.pruebadanieldos.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cafeconpalito.pruebadanieldos.domain.model.HoroscopeModel
import com.cafeconpalito.pruebadanieldos.domain.usecase.GetPredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Como va a obtener predicciones se le injecta con dagger hilt GetPredictionUseCase
 */
@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :ViewModel() {

    //Como valor inicial le paso el estado de Cargando
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    //devuelve el estado en el que se encuentra, por eso no es publica
    val state:StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscopeModel: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel){

        horoscopeModel = sign
        //Esta trabajando en el Hilo principal
        viewModelScope.launch {
            //HILO PRINCIPAL

            //Cambio el stado a loading.
            _state.value = HoroscopeDetailState.Loading

            //Esto lanza un hilo secundario, almaceno la respuesta en result
            val result =withContext(Dispatchers.IO){
                // VER LA CLASE GET PREDICTION
                // al usar la palabra "operator" en la funcion a la clase directamente y tratarla como una funcion accede a esta
                getPredictionUseCase(sign.name)
            }

            //HILO PRINCIPAL

            //si la respuesta es correcta
            if (result!=null){
                //Paso el esdado a Success y le paso el texto del horoscopo
                //SE PUEDE DEVOLVER EL OBJETO ENTERO O LO QUE NECESITEMOS.
                _state.value = HoroscopeDetailState.Success(result.horoscope, result.sign,horoscopeModel)
            } else{
                _state.value = HoroscopeDetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }




        }
    }

}