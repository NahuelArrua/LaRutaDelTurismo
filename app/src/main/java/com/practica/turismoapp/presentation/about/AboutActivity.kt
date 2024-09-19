package com.practica.turismoapp.presentation.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ortiz.touchview.BuildConfig
import com.practica.turismoapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

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