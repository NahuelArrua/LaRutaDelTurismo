package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.practica.turismoapp.Constants
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.databinding.ActivitySecondScreenBinding
import com.practica.turismoapp.repository.RepositoryTurismo.Companion.pegadaRepository
import kotlinx.coroutines.launch

class SecondScreentActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.reciclerView.setHasFixedSize(true)
        binding.reciclerView.layoutManager = GridLayoutManager(this, 1)
        //  binding.reciclerView.layoutManager = LinearLayoutManager(this)
        listadoTurismo()
    }

    fun listadoTurismo() {
        lifecycleScope.launch {
            val miRest = pegadaRepository()
            if (miRest.isSuccessful) {
                val listTurismo = miRest.body()?.Glamping
                binding.reciclerView.adapter = listTurismo?.let {
                    AdapterTurismo(it, object : TurismoClickedListener {
                        override fun onTurismoClicked(turismo: Turismo) {
                            Constants.traspasoDeTurismo = turismo
                            val intent = Intent(this@SecondScreentActivity, DescriptionActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    )
                }
            }
        }
    }
}