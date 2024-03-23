package com.cafeconpalito.pruebaramiro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {

    lateinit var ivDoubleCheck: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initUi()
    }
    private fun initVariables() {
        ivDoubleCheck = findViewById(R.id.ivDoubleCheck)
    }
    private fun initUi() {
        initVariables()
        initListeners()
    }
    private fun initListeners() {
        ivDoubleCheck.setOnClickListener {changeView()}
    }

    private fun changeView() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}