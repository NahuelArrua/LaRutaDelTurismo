package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.practica.turismoapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        /*
        Condición evaluada para verificar si la pantalla de presentación debe permanecer en la pantalla

        La pantalla de presentación permanecerá visible hasta que deje de cumplirse la condición. La condición
        se evalúa antes de cada solicitud para dibujar la aplicación, por lo que debe ser rápida para evitar
        bloquear la interfaz de usuario.
        */
        splashScreen.setKeepOnScreenCondition{true}
        Thread.sleep(1000)

        val intent = Intent(this, SecondScreentActivity::class.java)
        startActivity(intent)
    }
}