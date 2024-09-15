package com.practica.turismoapp.presentation.about

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ortiz.touchview.BuildConfig
import com.practica.turismoapp.R
import com.practica.turismoapp.databinding.ActivityAboutBinding

class About_Activity : AppCompatActivity() {

    lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            tvVersion.text = "ver.${BuildConfig.VERSION_NAME}"
        }
    }
}