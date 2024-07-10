package com.practica.turismoapp.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.practica.turismoapp.Constants
import com.practica.turismoapp.Constants.traspasoDeTurismo
import com.practica.turismoapp.R
import com.practica.turismoapp.databinding.ActivityDescripcionBinding


class DescripcionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionBinding

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivimagenUno.load(traspasoDeTurismo?.Fotos?.get(0)?.ImagenDetalle)
        binding.ivimagenDos.load(traspasoDeTurismo?.Fotos?.get(1)?.ImagenDetalle)

    }

    private fun openUrl(RedesSociales: String?) {
        val uri = Uri.parse(RedesSociales)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
