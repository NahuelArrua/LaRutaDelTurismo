package com.practica.turismoapp.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.R
import com.practica.turismoapp.databinding.ActivityFirstScreenBinding

class FirstScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.cardView2.setOnClickListener {
            intent = Intent(this, SecondScreentActivity::class.java)
            startActivity(intent)
        }
    }
}