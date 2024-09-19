package com.practica.turismoapp.presentation.login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.R

class loginActivity : AppCompatActivity() {

    val loginViewModel: LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
    }

    fun loginObserver(){
        loginViewModel.user.observeForever {

        }
    }
}