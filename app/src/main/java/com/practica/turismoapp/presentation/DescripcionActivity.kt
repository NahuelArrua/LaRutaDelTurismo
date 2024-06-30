package com.practica.turismoapp.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.Constants
import com.practica.turismoapp.R
import com.practica.turismoapp.databinding.ActivityDescripcionBinding


class DescripcionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionBinding
    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_descripcion)

        binding.tvLugares.text = Constants.traspasoDeTurismo?.Lugares


      /*
      binding.ivInstagram.setOnClickListener {
            openUrl("")
        }
      */
--r {
            openUrl(
                "https://www.facebook.com/?locale=es_LA"
                // Constants.traspasoDeTurismo?.RedesSociales
            )
        }

        binding.btnLugares.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.tvLugares.text = Constants.traspasoDeTurismo?.Lugares
        // binding.ivTurismo.load(Constants.traspasoDeTurismo?.Imagen)
        binding.ivInstagram.setOnClickListener { openUrl(Constants.traspasoDeTurismo?.RedesSociales) }

    }

    private fun openUrl(RedesSociales: String?) {
        val uri = Uri.parse(RedesSociales)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
