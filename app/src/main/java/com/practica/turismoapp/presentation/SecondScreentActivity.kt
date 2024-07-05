package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.practica.turismoapp.Constants
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.databinding.ActivitySecondScreenBinding
import com.practica.turismoapp.repository.RepositoryTurismo.Companion.pegadaRepository
import kotlinx.coroutines.launch

class SecondScreentActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding
    // private var mutableListaTurismo: MutableList<Turismo>

    private lateinit var adapter : AdapterTurismo
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

     /*

      binding.etFilter.addTextChangedListener { ProvinceFilter->
           val ProvinceFilter = mutableListaTurismo.filter { Turismo -> Turismo.Provincia.contains(ProvinceFilter.toString())}
            adapter.updateProvince(ProvinceFilter)
        }
   */


        //  val searchView = findViewById<SearchView>(R.id.SearchView)
        binding.reciclerView.setHasFixedSize(true)
        binding.reciclerView.layoutManager = GridLayoutManager(this, 1)
        //  binding.reciclerView.layoutManager = LinearLayoutManager(this)

        /*
        binding.SearchView.setOnQueryTextListener(object : OnQueryTextListener {
                override fun onQueryTextSubmit(text: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    return true
                }
            })
         */

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
                            val intent =
                                Intent(this@SecondScreentActivity, LugaresActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    )
                }
            }
        }
    }
}