package com.practica.turismoapp.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.practica.turismoapp.data.User
import com.practica.turismoapp.databinding.ActivityRegisterBinding
import com.practica.turismoapp.presentation.home.SecondScreentActivity

class RegisterActivity : AppCompatActivity() {

    val viewModel: RegisterViewModel = RegisterViewModel()
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setListener()
        setupObserver()
    }

    fun setListener() {
        binding.btnRegister.setOnClickListener {
            val user = User(
                user = binding.etUsuario.text.toString(),
                password = binding.etPassword.text.toString(),
                place = binding.etPlace.text.toString(),
                phone = binding.etPhone.text.toString(),
                email = binding.etEmail.text.toString(),
                enabled = true
            )
            viewModel.register(user)
        }
    }

    fun setupObserver(){
        viewModel.registro.observeForever {
            if (it?.enabled == true){
                startActivity(Intent(this, SecondScreentActivity::class.java))
            }else{
                Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.errorMessage.observeForever { error ->
            Toast.makeText(this, "${error.message} -- ${error.code}", Toast.LENGTH_SHORT).show()
        }
    }
}