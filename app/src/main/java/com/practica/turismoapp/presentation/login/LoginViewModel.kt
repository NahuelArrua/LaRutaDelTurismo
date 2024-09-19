package com.practica.turismoapp.presentation.login

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.repository.RepositoryUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class LoginViewModel: ViewModel() {

    val repositoryUser = RepositoryUser()

    private val _user:MutableLiveData<Boolean> = MutableLiveData(false)
    val user: LiveData<Boolean> = _user

    fun loginUser(){
        viewModelScope.launch {
            when(val usuario =  withContext(Dispatchers.IO){RepositoryUser.getUser()}){
                is ResultType.Success ->{
                    _user.value = loginUser()
                } is ResultType.Error -> Toast.makeText("this","el usuario o contraseña es incorrecto")
            }
        }
    }

}