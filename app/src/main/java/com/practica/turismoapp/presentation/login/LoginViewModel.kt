package com.practica.turismoapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.Constants.usuarioLogueado
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.User
import com.practica.turismoapp.repository.TurismoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {

    val repositoryTurismo = TurismoRepositoryImpl()

    private var _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private var _errorMessage = MutableLiveData<Boolean>()
    val errorMessage: LiveData<Boolean> = _errorMessage


    fun login(userLogin: User) {
        viewModelScope.launch {
            when (val registrer =
                withContext(Dispatchers.IO) { repositoryTurismo.getLogin(userLogin) }) {
                is ResultType.Success -> {
                    _user.value = registrer.data as User?
                    usuarioLogueado = user.value
                }

                is ResultType.Error -> _errorMessage.postValue(true)
            }
        }
    }
}