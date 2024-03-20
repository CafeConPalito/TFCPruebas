package com.cafeconpalito.pruebas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class comicActivity : AppCompatActivity() {

    private lateinit var btMainActivity: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comic_view)

        initUi() //Inicializa la UI
    }

    private fun initUi(){

        initVariables()
        initListeners()

    }

    private fun initVariables() {

        btMainActivity = findViewById(R.id.btMainActivity)

    }
    private fun initListeners() {
        btMainActivity.setOnClickListener { changeView() }
    }

    private fun changeView() {

        val intent: Intent =  Intent(this,MainActivity::class.java)
        startActivity(intent)

    }


}