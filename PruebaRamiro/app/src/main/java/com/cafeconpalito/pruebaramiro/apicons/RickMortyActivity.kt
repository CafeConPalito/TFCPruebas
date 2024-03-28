package com.cafeconpalito.pruebaramiro.apicons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafeconpalito.pruebaramiro.apicons.DetailCharacterActivity.Companion.EXTRA_ID
import com.cafeconpalito.pruebaramiro.databinding.ActivityRickMortyBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Suppress("NAME_SHADOWING")
class RickMortyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRickMortyBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: RMAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRickMortyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetroFit()
        initUi()
    }

    private fun initUi() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })

        adapter = RMAdapter {
            navigateToDetail(it)
        }
        binding.rvRickMorty.setHasFixedSize(true)
        binding.rvRickMorty.layoutManager = LinearLayoutManager(this)
        binding.rvRickMorty.adapter = adapter


    }


    //getCharacters(name.orEmpty())
    private fun searchByName(name: String?) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<RMDataResponse> =
                retrofit.create(ApiService::class.java).getCharacters(name)
            if (response.isSuccessful) {
                val response: RMDataResponse? = response.body()
                if (response != null) {
                    runOnUiThread {
                        adapter.updateList(response.results)
                        binding.progressBar.isVisible = false
                    }
                } else {

                }
            }

        }


    }

    fun getRetroFit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id: Int) {
        val intent = Intent(this, DetailCharacterActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }
}