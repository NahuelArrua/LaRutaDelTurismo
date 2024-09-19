package com.practica.turismoapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.User
import com.practica.turismoapp.repository.RepositoryTurismoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel: ViewModel() {

    val repositoryTurismo = RepositoryTurismoImpl()

    private var _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private var _errorMessage = MutableLiveData<Boolean>()
    val errorMessage: LiveData<Boolean> = _errorMessage


    fun login(user: User) {
        viewModelScope.launch {
            when (val caca = withContext(Dispatchers.IO){ repositoryTurismo.getLogin(user) }) {
                is ResultType.Success -> {
                    _user.value = caca.data as User?
                }
                is ResultType.Error -> _errorMessage.postValue(true)
            }
        }
    }

}