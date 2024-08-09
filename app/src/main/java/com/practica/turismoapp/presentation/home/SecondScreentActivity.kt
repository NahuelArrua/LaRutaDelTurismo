package com.practica.turismoapp.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.practica.turismoapp.Constants.traspasoDeTurismo
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.databinding.ActivitySecondScreenBinding
import com.practica.turismoapp.presentation.AdapterTurismo
import com.practica.turismoapp.presentation.DescripcionActivity
import com.practica.turismoapp.presentation.TurismoClickedListener

class SecondScreentActivity : AppCompatActivity() {

    private val homeViewModel = HomeViewModel()

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.reciclerView.setHasFixedSize(true)
        binding.reciclerView.layoutManager = GridLayoutManager(this, 1)

        setObserver()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finishAffinity()
    }

    private fun setObserver() {
        homeViewModel.turismoGlam.observe(this) { lista ->

            // TODO solo para ver como recorre el map anidado
            lista.Glamping.map { glamping ->
                Log.d("Seba","Imagen" + glamping.ImagenPrincipal)//Es la imagen de la tabla glamping
                glamping.Fotos?.map { lugar ->
                    Log.d("Seba","Foto " + lugar.ImagenDetalle ?: "sin url de foto")//Es la imagen de la tabla photo
                }
            }

            binding.reciclerView.adapter = lista.let {
                AdapterTurismo(it.Glamping, object : TurismoClickedListener {
                    override fun onTurismoClicked(turismo: Turismo) {
                        traspasoDeTurismo = turismo
                        val intent =
                            Intent(this@SecondScreentActivity, DescripcionActivity::class.java)
                        startActivity(intent)
                    }
                }
                )
            }
        }
        homeViewModel.getLugares()
    }
}