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

class UpLoadActivity : AppCompatActivity() {

    val viewModel: UpLoadViewModel = UpLoadViewModel()
    private lateinit var binding: ActivityUpLoadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityUpLoadBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        refrescarListadoDeCarga()
        setupButtonListener()
        setupObserver()
       // idEditPlaces()

    }

    fun setupButtonListener(){


        binding.ivAddImageOne.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",0) }) }

        binding.ivAddImageTwo.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",1) }) }

        binding.ivAddImageTrhee.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",2) }) }

        binding.ivAddImageFor.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",3) }) }

        binding.ivAddImageFive.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",4) }) }

        binding.ivAddImageSix.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",5) }) }

        binding.ivAddImageSeven.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",6) }) }

        binding.ivAddImageEight.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",7) }) }

        binding.ivAddImageNine.setOnClickListener {
            startActivity(Intent(this, SelectorActivity::class.java).apply {
                putExtra("posicion",8) }) }

        binding.btnDataUpload.setOnClickListener {
            // TODO: mandar a la api

        }

        binding.btnDataUpload.setOnClickListener {
            val glampingNuevo = Constants.grillaGlamping?.let { it1 ->
                Turismo(
                    Id = it1.Glamping,
                    Lugares = binding.etPLaces.text.toString(),
                    Provincia = binding.etProvincia.text.toString(),
                    Servicios = binding.etDescriptionTwo.text.toString(),
                    ImagenPrincipal = Constants.listaDeImagenes[0],
                    Descripcion = binding.etDescription.text.toString(),
                    RedesSociales = binding.etInstagram.text.toString(),
                    Fotos = listToFoto(Constants.listaDeImagenes.slice(1..8))
                )
            }
            if (glampingNuevo != null) {
                viewModel.upLoad(glampingNuevo)
            }
            Toast.makeText(this,"ok", Toast.LENGTH_SHORT).show()
        }

    }
    private fun buscarId(id: Int) {
        Constants.glampingLoad = Constants.grillaGlamping?.Glamping?.find { glamp ->
            glamp.Id?.equals(id) == true
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


  fun setupObserver(){
        viewModel.upload.observeForever { listaTurismo ->
            if (listaTurismo!= null){
                buscarId(

                    listaTurismo.Id)
                startActivity(Intent(this, SecondScreentActivity::class.java))
            }else{
                Toast.makeText(this, "Error al intentar publicar", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.errorMessage.observeForever { error ->
            Toast.makeText(this, "${error.message} -- ${error.code}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        refrescarListadoDeCarga()
    }

}