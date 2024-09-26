package com.practica.turismoapp.presentation.selector

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.practica.turismoapp.R

class SelectorActivity : AppCompatActivity() {

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri!=null) {
            ivSelector.setImageURI(uri)
        } else {
            Toast.makeText(this, "no has seleccionado ninguna imagen", Toast.LENGTH_SHORT).show()
        }
    }

    lateinit var btnImage: Button
    lateinit var ivSelector: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selector)
        btnImage = findViewById(R.id.btnImage)
        ivSelector = findViewById(R.id.ivSelector)

        ivSelector.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }


}