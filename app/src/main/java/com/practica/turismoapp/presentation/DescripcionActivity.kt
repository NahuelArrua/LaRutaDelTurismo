package com.practica.turismoapp.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.practica.turismoapp.Constants
import com.practica.turismoapp.Constants.traspasoDeTurismo
import com.practica.turismoapp.databinding.ActivityDescripcionBinding


class DescripcionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivimagenUno.load(traspasoDeTurismo?.Fotos?.let { it.get(0).ImagenDetalle })
        binding.ivimagenDos.load(traspasoDeTurismo?.Fotos?.let { it.get(1).ImagenDetalle })
        binding.imageone.load(traspasoDeTurismo?.Fotos?.let { it.get(2).ImagenDetalle }) { this.size(600,500) }
        binding.ivGastronomy.load(traspasoDeTurismo?.Fotos?.let { it.get(3).ImagenDetalle })
        binding.ivContenido.load(traspasoDeTurismo?.Fotos?.let { it.get(4).ImagenDetalle })
        binding.ivContenidoDos.load(traspasoDeTurismo?.Fotos?.let { it.get(5).ImagenDetalle })
        binding.ivContenidoTres.load(traspasoDeTurismo?.Fotos?.let { it.get(6).ImagenDetalle })
        binding.ivContenidoCuatro.load(traspasoDeTurismo?.Fotos?.let { it.get(7).ImagenDetalle })

        binding.textServicios.text = Constants.traspasoDeTurismo?.Servicios
        binding.textLugares.text = Constants.traspasoDeTurismo?.Lugares
        binding.textDescripcion.text = Constants.traspasoDeTurismo?.Descripcion
        binding.ivInstagram.setOnClickListener { openUrl(Constants.traspasoDeTurismo?.RedesSociales) }
        binding.ivwhatssap.setOnClickListener { openUrl(Constants.traspasoDeTurismo?.RedesSociales) }
    }

    private fun openUrl(RedesSociales: String?) {
        val uri = Uri.parse(RedesSociales)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

}
