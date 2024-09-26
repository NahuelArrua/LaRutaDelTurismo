package com.practica.turismoapp.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.data.User
import com.practica.turismoapp.databinding.ActivityLoginBinding
import com.practica.turismoapp.presentation.selector.SelectorActivity

class LoginActivity : AppCompatActivity() {

    val viewModel: LoginViewModel = LoginViewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupObservers()
        setListener()
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

        viewModel.user.observeForever {
            it?.let {
                if (it.enabled) {
                    startActivity(Intent(this, SelectorActivity::class.java))

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
}