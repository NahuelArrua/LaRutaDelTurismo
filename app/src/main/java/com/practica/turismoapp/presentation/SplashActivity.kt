package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.R
import com.practica.turismoapp.presentation.home.SecondScreentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

    }

    override fun onResume() {
        super.onResume()
        runBlocking {
            delay(3000)
            val intent = Intent(this@SplashActivity, SecondScreentActivity::class.java)
            startActivity(intent)
        }

    }
}