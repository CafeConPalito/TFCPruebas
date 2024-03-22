package com.cafeconpalito.pruebas.activity_controllers

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.cafeconpalito.pruebas.MainActivity
import com.cafeconpalito.pruebas.databinding.ComicViewBinding
import com.cafeconpalito.pruebas.viewModel.ComicViewModel
import com.squareup.picasso.Picasso
import kotlin.random.Random

class ComicActivity : AppCompatActivity() {

    //Preparando el Bindind de otra clase, clada view tiene su Binding con el cual se construye
    private lateinit var binding: ComicViewBinding

    private lateinit var ivComic:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflando el binding con la info del layout
        binding = ComicViewBinding.inflate(layoutInflater)
        //pasando el layout de la vista
        setContentView(binding.root)

        initUi() //Inicializa la UI
    }

    private fun initUi(){

        initVariables()
        initListeners()

    }

    private fun initVariables() {

        ivComic= binding.ivComic

    }
    private fun initListeners() {
        binding.btGoMain.setOnClickListener { changeView() }
        binding.btNewComic.setOnClickListener { loadNewComic()}
    }

    //Probmeas con la Corrutina
    private fun loadNewComic() {

        val random:Int = Random.nextInt(1,1000)
        val cvm:ComicViewModel = ComicViewModel()
        cvm.getComic(random)

        //Se ocupa de pintar cuando tengo una imagen nueva.
        cvm.comicLiveData.observe(this@ComicActivity
        ) { comic ->
            Picasso.get().load(comic.img.toString()).into(binding.ivComic)
        }


    }

    private fun changeView() {

        val intent: Intent =  Intent(this, MainActivity::class.java)
        startActivity(intent)

    }


}