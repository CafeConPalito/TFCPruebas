package com.cafeconpalito.pruebas.viewModel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cafeconpalito.pruebas.entities.Comic
import com.cafeconpalito.pruebas.services.ComicService
import kotlinx.coroutines.launch

class ComicViewModel : ViewModel() {

    //La lista que vamos a devolver con la info
    val comicLiveData = MutableLiveData<Comic>()
    //La lista que mientras carga los datos esta mostrando datos Dummies
    val isLoading = MutableLiveData<Boolean>()

    private val cs = ComicService()

    fun getComic(idComic:Int){

        viewModelScope.launch {

            isLoading.postValue(true)
            val response = cs.getComic(idComic)

            comicLiveData.postValue(response)

            isLoading.postValue(false)

        }

    }
}