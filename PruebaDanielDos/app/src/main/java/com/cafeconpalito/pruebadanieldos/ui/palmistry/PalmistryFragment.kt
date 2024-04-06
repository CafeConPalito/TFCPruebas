package com.cafeconpalito.pruebadanieldos.ui.palmistry

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.cafeconpalito.pruebadanieldos.data.network.NetworkModule
import com.cafeconpalito.pruebadanieldos.databinding.FragmentPalmistryBinding
import com.cafeconpalito.pruebadanieldos.domain.model.ChickModel
import com.cafeconpalito.pruebadanieldos.domain.usecase.GetChicksUseCase
import com.cafeconpalito.pruebadanieldos.domain.usecase.GetLogin
import com.cafeconpalito.pruebadanieldos.ui.detail.HoroscopeDetailState
import com.cafeconpalito.pruebadanieldos.ui.detail.HoroscopeDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint

class PalmistryFragment() : Fragment() {

    //Manera de trabajar con Binding y Fragmentos
    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var getLogin: GetLogin // Injected dependency

    @Inject
    lateinit var getChicksUseCase: GetChicksUseCase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //Cargando el Binding para Un fragmento
        _binding = FragmentPalmistryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Comprobamos si el permiso es correcto

        initUI()

    }

    private fun initUI() {

        //initTexts()
        loggin()
        //loggin2()
    }



    private fun initTexts() {
        //CAPTURA EL TEXTO
        // val text = binding.tvJWT.text

        //Funciona como seter y geter
        //val text = "Hola Mundito"
        //binding.tvJWT.text = text

        //Log.i ("getLogin", "IMPOSIBLE LOGUEAR: ${text}")
        //binding.tvNetWork.setText("Que tal estas")
    }



    private val palmstryViewModel: PalmstryViewModel by viewModels()
    private fun loggin2() {

        val user = "@usuario1"
        val password = "a722c63db8ec8625af6cf71cb8c2d939"

        //Hilo que esta pendiente de la vida de la VIEW, si la view muere el para!
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                palmstryViewModel.state.collect {
                    //Siempre que cambien el estado hara lo siguiente
                    when (it) {
                        //it es la informacion del estado que puede contener informacion.
                        //Cada cambio de estado llama a su metodo
                        PalmstryState.Loading -> loadingState()
                        is PalmstryState.Error -> errorState(it)
                        is PalmstryState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun successState(it: PalmstryState.Success) {
        binding.tvJWT.text = it.apiKey
    }

    private fun errorState(it: PalmstryState.Error) {

        binding.tvJWT.text = it.error
    }

    private fun loadingState() {
        binding.tvJWT.text = "LOADING"
    }




    fun loggin() {


        val user = "@usuario1"
        val password = "a722c63db8ec8625af6cf71cb8c2d939"


        //ESTO SE UTILIZA CUANDO ES UN FRAGMENTO
        var JWT: String?
        var chicks: List<ChickModel>?


        //Hilo normal
        CoroutineScope(Dispatchers.IO).launch {

            JWT = getLogin(user, password)
            Log.i("My ApiKey: ", JWT.toString())

            if (JWT != null) {
                NetworkModule.AuthKey = JWT.toString()
                Log.i("My ApiKey Network: ", NetworkModule.AuthKey)

                chicks = getChicksUseCase()

                //chicks = getLogin.getChiks()
                if (chicks != null) {

                    for (chick in chicks!!){

                        Log.i("My Chicks: ", chick.toString())

                    }
                }

            }
        }


        /*



                // ESTO ES LO QUE REVIENTA!!!!

                rmViewModel.getByName(name)

                rmViewModel.rickMortyLiveData.observe(viewLifecycleOwner,{ ListCharacters ->
                    with(binding.rvRickMortyCharacterList) {
                        //Selecciono el tipo de Layout para el RV
                        layoutManager =
                            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                        //Paso la nueva lista de datos!
                        adapter = RickMortyAdapter(ListCharacters) {
                            /*
                            //CREO QUE ESTO NO ES NECESARIO
                            val intentDetail = Intent(context, DetailActivity::class.java)
                            intentDetail.putExtra(EXTRA, it)
                            startActivity(intentDetail)
                            */
                        }

                    }
                })

                //Mientras no carge estara sin ser visible...
                rmViewModel.isLoading.observe(this@RickMortyActivity,  { isLoading ->
                    binding.pbLoading.isVisible = isLoading
                })

            }





        viewModelScope.launch {
            //HILO PRINCIPAL

            //Cambio el stado a loading.
            _state.value = HoroscopeDetailState.Loading

            //Esto lanza un hilo secundario, almaceno la respuesta en result
            val result = withContext(Dispatchers.IO){
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

        */


    }

}

