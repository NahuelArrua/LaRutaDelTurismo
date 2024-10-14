package com.practica.turismoapp.presentation.selector

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.practica.turismoapp.Constants.listaDeImagenes
import com.practica.turismoapp.R
import com.practica.turismoapp.databinding.ActivitySelectorBinding

class SelectorActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectorBinding
    private var viewModel = SelectorViewModel()
    private val ctx = this
    var imgPath: String? = null
    var originIndex = 0

    val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            binding.ivPhoto.setImageURI(uri)
            imgPath = RealPathUtil.getRealPath(ctx, uri)
            viewModel.takeFile(true)
        } else {
            viewModel.takeFile(false)
            Toast.makeText(this, "no has seleccionado ninguna imagen", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySelectorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        setupLister()
        setupObservers()
        setupPermission()
        // Leer de que boton biene
        originIndex = intent.getIntExtra("posicion", 0 )
    }

    private fun setupPermission() {
        val requestPermissionsLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {}
        val permissions = getPermissionFiles()
        val allPermissionsGranted = permissions.all { permission ->
            ContextCompat.checkSelfPermission(ctx, permission) == PackageManager.PERMISSION_GRANTED
        }

        if (!allPermissionsGranted) {
            requestPermissionsLauncher.launch(permissions.toTypedArray())
        }

    }

    private fun getPermissionFiles(): MutableList<String> {
        val permissions = mutableListOf<String>()
        permissions.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        return permissions
    }

    private fun setupObservers() {
        viewModel.compartirEnabled.observe(this) {
            binding.btnCompartir.isEnabled = it
        }

        viewModel.fileUploaded.observe(this) { archivoSubido ->
            archivoSubido.fileDownloadUri?.let { archivo ->
                listaDeImagenes[originIndex] = archivo
            }
            binding.progressBar.visibility = View.GONE
            finish()
        }

        viewModel.errorMessage.observe(this) {
            if (it) {
                AlertDialog.Builder(this)
                    .setIcon(R.drawable.error_message)
                    .setTitle(getString(R.string.upps))
                    .setMessage(getString(R.string.error_al_levantar_el_archivo))
                    .setPositiveButton(getString(R.string.entendido)) { _, _ ->
                        finish()
                    }
                    .setOnDismissListener { finish() }
                    .show()
                    .run {
                        getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.black))
                    }
            }
        }
    }

    fun setupLister() {
        binding.apply {
            ivTake.setOnClickListener {
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
            btnCompartir.setOnClickListener {
                if (imgPath != null) {
                    progressBar.visibility = View.VISIBLE
                    viewModel.sendPhoto(imgPath!!, ctx)
                }
            }
        }
    }
}