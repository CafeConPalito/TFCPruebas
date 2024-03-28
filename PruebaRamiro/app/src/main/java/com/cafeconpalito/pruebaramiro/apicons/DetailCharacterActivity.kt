package com.cafeconpalito.pruebaramiro.apicons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.cafeconpalito.pruebaramiro.R
import com.cafeconpalito.pruebaramiro.databinding.ActivityDetailCharacterBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailCharacterActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "id"
    }

    private lateinit var binding:ActivityDetailCharacterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id  = intent.getIntExtra(EXTRA_ID, 0)
        getCharacterInformation(id)
    }

    private fun getCharacterInformation(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = getRetroFit().create(ApiService::class.java).getCharacterById(id)
            if (response.body() != null) {
                runOnUiThread() {
                    createUI(response.body()!!)
                }
            }else{
                runOnUiThread() {
                    binding.tvnombre.text = id.toString()
                }
            }

        }

    }

    private fun createUI(body: CharacterDetailResponse) {

        val species = if (body.species.isEmpty()) "Not Set" else body.species
        val type = if (body.type.isEmpty()) "Not Set" else body.type

        Picasso.get().load(body.image).into(binding.ivCharacterImage2)
        binding.tvnombre.text = body.name
        binding.tvstatus.text = "Status: " + body.status
        binding.tvspecies.text = "Species: " + species
        binding.tvtype.text = "Type: " + type

    }

    fun getRetroFit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}