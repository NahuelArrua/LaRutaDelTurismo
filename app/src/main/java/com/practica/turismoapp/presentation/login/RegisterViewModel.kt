package com.practica.turismoapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.User
import com.practica.turismoapp.presentation.model.ErrorResponse
import com.practica.turismoapp.repository.TurismoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel : ViewModel() {

    private val repositoryTurismo = TurismoRepositoryImpl()

    private val _registro = MutableLiveData<User?>()
    val registro: LiveData<User?> = _registro

    private var _errorMessage = MutableLiveData<ErrorResponse>()
    val errorMessage: LiveData<ErrorResponse> = _errorMessage

    fun register(user: User) {
        viewModelScope.launch {
            when (val response =
                withContext(Dispatchers.IO) { repositoryTurismo.getRegister(user) }) {
                is ResultType.Success -> {
                    _registro.value = response.data as? User
                }

                is ResultType.Error -> {
                    _errorMessage.postValue(
                        ErrorResponse(
                            code = response.code,
                            message = response.message
                        )
                    )
                }
            }
        }
    }

}