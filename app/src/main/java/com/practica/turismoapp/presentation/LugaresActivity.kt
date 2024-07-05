package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Contacts
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.practica.turismoapp.Constants
import com.practica.turismoapp.data.Foto
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.databinding.ActivityLugaresBinding


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

      //  binding.tvLugares.text = Constants.traspasoDeTurismo?.Lugares
        binding.ivProvincias.load(Constants.traspasoDeTurismo?.Imagen)
        binding.tvDescripcion.text = Constants.traspasoDeTurismo?.Descripcion
        binding.tvProvincia.text = Constants.traspasoDeTurismo?.Provincia
    }
}