package com.cafeconpalito.pruebas.viewModel

import Characters
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cafeconpalito.pruebas.services.RickMortyService
import kotlinx.coroutines.launch

class RickMortyViewModel:ViewModel() {

    //La lista que vamos a devolver con la info
    val rickMortyLiveData = MutableLiveData<List<Characters>>()
    //La lista que mientras carga los datos esta mostrando datos Dummies
    val isLoading = MutableLiveData<Boolean>()

    private val rms = RickMortyService()
    fun getByName(name:String){
        viewModelScope.launch {

            isLoading.postValue(true)
            val response = rms.getByName(name)
            rickMortyLiveData.postValue(response)
            isLoading.postValue(false)

        }

    }

}