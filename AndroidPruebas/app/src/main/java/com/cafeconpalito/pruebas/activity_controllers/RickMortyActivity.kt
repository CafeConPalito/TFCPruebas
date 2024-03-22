package com.cafeconpalito.pruebas.activity_controllers

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafeconpalito.pruebas.databinding.RickMortyViewBinding
import com.cafeconpalito.pruebas.viewModel.RickMortyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RickMortyActivity : AppCompatActivity() {

    private lateinit var binding: RickMortyViewBinding

    //El encargado de tener los datos para mostrar en el Recicler View
    //EL ciclo de vida esta anclado a la vida de la activity
    //Puede ser de tipo fragmente activityViewModel()
    private val rmViewModel : RickMortyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RickMortyViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {

        initListeners()

    }

    private fun initListeners() {

        //Implementacion del SearchView
        binding.svFindCharacter.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {

            //Realiza la busqueda al darle a buscar
            override fun onQueryTextSubmit(query: String?): Boolean {
                //Busca un super heroe por nombre envia la query si no tiene nada la envia vacia
                searchByName(query.orEmpty())
                return false
            }

            //Realiza la busqueda al ir escribiendo, si no se utilizan se dejan en False.
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        }
        )
    }

    private fun searchByName(name: String) {

        var nameTwo:String = "Rick"

        //Toast.makeText(this@RickMortyActivity, name, Toast.LENGTH_LONG).show()

        //Lanza la busqueda Dentro del mismo Activity

        rmViewModel.getByName(name)

        rmViewModel.rickMortyLiveData.observe(this,{ ListCharacters ->
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
        rmViewModel.isLoading.observe(this,  { isLoading ->
            binding.pbLoading.isVisible = isLoading
        })


        //ESTO SE UTILIZA CUANDO ES UN FRAGMENTO

        /*
            CoroutineScope(Dispatchers.IO).launch {


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
            */
    }
}


