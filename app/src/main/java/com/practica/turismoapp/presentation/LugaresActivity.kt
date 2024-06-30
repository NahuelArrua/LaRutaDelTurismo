package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.Constants
import com.practica.turismoapp.databinding.ActivityLugaresBinding


class LugaresActivity : AppCompatActivity() {
  private lateinit var binding: ActivityLugaresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       binding = ActivityLugaresBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.tvLugares.setOnClickListener {
            intent = Intent(this, DescripcionActivity::class.java)
            startActivity(intent)
        }



        binding.tvLugares.text = Constants.traspasoDeTurismo?.Lugares
        binding.tvLugaresTwo.text = Constants.traspasoDeTurismo?.Descripcion

    }
}