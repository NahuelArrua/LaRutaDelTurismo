package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.practica.turismoapp.Constants
import com.practica.turismoapp.databinding.ActivityLugaresBinding
import com.practica.turismoapp.presentation.about.About_Activity


class LugaresActivity : AppCompatActivity() {
  private lateinit var binding: ActivityLugaresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLugaresBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvProvincia.setOnClickListener {
            intent = Intent(this, DescripcionActivity::class.java)
            startActivity(intent)
        }
        binding.ivProvincias.setOnClickListener {
            intent = Intent(this, About_Activity::class.java)
            startActivity(intent)
        }

      //  binding.tvLugares.text = Constants.traspasoDeTurismo?.Lugares
        binding.ivProvincias.load(Constants.traspasoDeTurismo?.ImagenPrincipal)
        binding.tvDescripcion.text = Constants.traspasoDeTurismo?.Descripcion
        binding.tvProvincia.text = Constants.traspasoDeTurismo?.Provincia

    }

}