package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.R
import com.practica.turismoapp.presentation.home.SecondScreentActivity

class SplashActivity : AppCompatActivity() {

    val splashViewModel: SplashViewModel = SplashViewModel()
    val ctx = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        initObserver()
    }


    fun initObserver() {
        splashViewModel.screen.observeForever { screen ->
            when (screen) {
                true -> goToHome()
                false -> splashViewModel.initCount()
            }
        }
    }

    fun goToHome() {
        startActivity(Intent(ctx, SecondScreentActivity::class.java))
    }

}