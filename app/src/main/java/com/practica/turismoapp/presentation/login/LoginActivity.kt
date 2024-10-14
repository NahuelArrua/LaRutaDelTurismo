package com.practica.turismoapp.presentation.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.v
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.Constants
import com.practica.turismoapp.data.User
import com.practica.turismoapp.databinding.ActivityLoginBinding
import com.practica.turismoapp.presentation.selector.SelectorActivity
import com.practica.turismoapp.presentation.selector.UpLoadActivity

class LoginActivity : AppCompatActivity() {

    val viewModel: LoginViewModel = LoginViewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupObservers()
        setListener()
        register()
    }

    fun setListener() {
        binding.btnLogin.setOnClickListener {
            val user = User(
                user = binding.tvUsuario.text.toString(),
                password = binding.tvPassword.text.toString(),
                place = "",
                enabled = false
            )
            viewModel.login(user)
        }
    }

    fun setupObservers() {

        viewModel.user.observeForever { usuario ->
            usuario?.let {
                if (it.enabled) {
                    buscarSiTieneGlamping(usuario.place)
                    startActivity(Intent(this, UpLoadActivity::class.java))

                } else {
                    Toast.makeText(this, "Cuenta Deshabilitada", Toast.LENGTH_SHORT).show()
                }
            } ?: Toast.makeText(this, "Cuenta Inexistente", Toast.LENGTH_SHORT).show()

        }

        viewModel.errorMessage.observeForever {
            if (it == true) {
                Toast.makeText(this, "Error: Cuenta Inexistente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun buscarSiTieneGlamping(lugar: String) {
        Constants.glampingLoad = Constants.grillaGlamping?.Glamping?.find { glamp ->
            glamp.Lugares.equals(lugar)
        }
    }

    fun register(){
        binding.tvRegistrarse.setOnClickListener {
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}