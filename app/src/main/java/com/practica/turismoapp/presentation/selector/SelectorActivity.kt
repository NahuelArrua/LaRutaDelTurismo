package com.practica.turismoapp.presentation.selector

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.practica.turismoapp.R
import com.practica.turismoapp.databinding.ActivitySelectorBinding
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SelectorActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectorBinding
    private var viewModel = SelectorViewModel()
    private val ctx = this
    var imgPath: String? = null

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
    }

    private fun setupObservers() {
        viewModel.compartirEnabled.observe(this) {
            binding.btnCompartir.isEnabled = it
        }
        viewModel.fileUploaded.observe(this) {
            lifecycleScope.launch {
                Toast.makeText(ctx,"Imagen subida en ${it.fileDownloadUri}",Toast.LENGTH_SHORT).show()
                delay(2_000L)
                finishAffinity()
            }
        }
        viewModel.errorMessage.observe(this) {
            if (it) {
                AlertDialog.Builder(this)
                    .setIcon(R.drawable.error_message)
                    .setTitle(getString(R.string.upps))
                    .setMessage(getString(R.string.error_al_levantar_el_archivo))
                    .setPositiveButton(getString(R.string.entendido)) { _, _ ->
                        finishAffinity()
                    }
                    .setOnDismissListener { finishAffinity() }
                    .show()
                    .run {
                        getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.black))
                    }
            }
        }
    }

    fun setupLister() {
        binding.apply {
            ivPhoto.setOnClickListener {
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
            btnCompartir.setOnClickListener {
                if (imgPath != null) {
                    viewModel.sendPhoto(imgPath!!, ctx)
                }
            }
        }
    }
}