package com.practica.turismoapp.presentation.selector

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.practica.turismoapp.Constants
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.data.Foto
import com.practica.turismoapp.databinding.ActivityUpLoadBinding
import com.practica.turismoapp.presentation.home.SecondScreentActivity
import com.practica.turismoapp.data.TurismoGlam as DataTurismoGlam

class UpLoadActivity : AppCompatActivity() {

    val viewModel: UpLoadViewModel = UpLoadViewModel()
    private lateinit var binding: ActivityUpLoadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUpLoadBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        refrescarListadoDeCarga()
        setupButtonListener()
      //  setupObserver()

    }

    fun setupButtonListener(){

        binding.btnLugar.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java)) }

        binding.ivAddImageOne.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",0) }) }

        binding.ivAddImageTwo.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",2) }) }

        binding.ivAddImageTrhee.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",3) }) }

        binding.ivAddImageFor.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",4) }) }

        binding.ivAddImageFive.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",5) }) }

        binding.ivAddImageSix.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",6) }) }

        binding.ivAddImageSeven.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",7) }) }

        binding.ivAddImageEight.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",8) }) }

        binding.ivAddImageNine.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",9) }) }

        binding.btnDataUpload.setOnClickListener {
            // TODO: mandar a la api

        }

        binding.btnDataUpload.setOnClickListener {
            val glampingNuevo = Turismo(
                Id = 0,
                Lugares = binding.btnLugar.text.toString(),
                Provincia = "",
                Servicios = "",
                ImagenPrincipal = Constants.listaDeImagenes[0],
                Descripcion = "",
                RedesSociales = "",
                Fotos = listToFoto(Constants.listaDeImagenes.slice(1..8))
            )
            viewModel.upLoad(glampingNuevo)
            Toast.makeText(this,"ok", Toast.LENGTH_SHORT).show()

        }
    }

    private fun listToFoto(listArchivos: List<String>): List<Foto>? {
        var listFoto: MutableList<Foto> = mutableListOf()
        listArchivos.forEach { item ->
            listFoto.add(Foto(ImagenDetalle = item))
        }
        return listFoto
    }

    private fun refrescarListadoDeCarga() {
        Constants.listaDeImagenes.forEachIndexed { index, imagen ->
            binding.apply {
                if (index == 0) {
                    ivPhotoUno.load(imagen)
                    Log.d("Nah", "entro en refrescarListadoDeCarga()")
                }
                if (index == 1) { ivPhotoDos.load(imagen) }
                if (index == 2) { ivPhotoTres.load(imagen) }
                if (index == 3) { ivPhotoCuatro.load(imagen) }
                if (index == 4) { ivPhotoCinco.load(imagen) }
                if (index == 5) { ivPhotoSies.load(imagen) }
                if (index == 6) { ivPhotoSiete.load(imagen) }
                if (index == 7) { ivPhotoOcho.load(imagen) }
                if (index == 8) { ivPhotoNueve.load(imagen) }
            }

        }
    }

 /*
 *  fun setupObserver(){
        viewModel.upload.observeForever { listaTurismo ->
            if (listaTurismo){
                startActivity(Intent(this, SecondScreentActivity::class.java))
            }else{
                Toast.makeText(this, "Error al intentar publicar", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.errorMessage.observeForever { error ->
            Toast.makeText(this, "${error.message} -- ${error.code}", Toast.LENGTH_SHORT).show()
        }
    }
 *
 * */

    override fun onPostResume() {
        super.onPostResume()
        refrescarListadoDeCarga()
    }
}