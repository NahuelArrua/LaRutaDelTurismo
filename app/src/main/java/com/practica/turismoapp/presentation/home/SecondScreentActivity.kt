package com.practica.turismoapp.presentation.home

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.practica.turismoapp.Constants.traspasoDeTurismo
import com.practica.turismoapp.R
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

        homeViewModel.errorMessage.observe(this) {
            if (it) {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.upps))
                    .setMessage(getString(R.string.fail_connection))
                    .setPositiveButton(getString(R.string.entendido)) { _, _ ->
                        finishAffinity()
                    }
                    .setOnDismissListener { finishAffinity() }
                    .setIcon(R.drawable.error_message)
                    .show()
                    .run {
                        getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.black))
                    }
            }
        }

        homeViewModel.getLugares()
    }
}