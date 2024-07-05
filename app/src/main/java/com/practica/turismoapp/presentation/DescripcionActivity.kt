package com.practica.turismoapp.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.practica.turismoapp.Constants
import com.practica.turismoapp.R
import com.practica.turismoapp.databinding.ActivityDescripcionBinding


class DescripcionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionBinding

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.ivimagenUno.load(Constants.traspasoDeTurismo?.Imagen)
        binding.ivimagenDos.load(Constants.traspasoDeTurismo?.Servicios)

//        var item = Constants.traspasoDeTurismo

//        with(binding){
//            item?.let {
//                it.Fotos?.let {
//                    ivimagenUno.load(it.get(0).imagen)
//                    ivimagenDos.load(it.get(1).imagen)
//                }
//        }

      //  binding.tvLugares.text = Constants.traspasoDeTurismo?.Lugares


      /*
      binding.ivInstagram.setOnClickListener {
            openUrl("")
        }
      *//*

      {
            openUrl(
                "https://www.facebook.com/?locale=es_LA"
                // Constants.traspasoDeTurismo?.RedesSociales
            )
        }
      */

       /*
       binding.btnLugares.setOnClickListener {
            intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

      */

        //binding.tvLugares.text = Constants.traspasoDeTurismo?.Lugares
        // binding.ivTurismo.load(Constants.traspasoDeTurismo?.Imagen)
       // binding.ivInstagram.setOnClickListener { openUrl(Constants.traspasoDeTurismo?.RedesSociales) }

    }

    private fun openUrl(RedesSociales: String?) {
        val uri = Uri.parse(RedesSociales)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
