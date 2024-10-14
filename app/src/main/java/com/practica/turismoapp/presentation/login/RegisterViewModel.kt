package com.practica.turismoapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.Registro
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.presentation.model.ErrorResponse
import com.practica.turismoapp.repository.TurismoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel : ViewModel() {

    val repositoryTurismo = TurismoRepositoryImpl()

    private val _regitro = MutableLiveData<Registro?>()
    val registro: LiveData<Registro?> = _regitro

    private var _errorMessage = MutableLiveData<ErrorResponse>()
    val errorMessage: LiveData<ErrorResponse> = _errorMessage

    fun register(registro: Registro) {
        viewModelScope.launch {
            when (val registrer =
                withContext(Dispatchers.IO) { repositoryTurismo.getRegister(registro) }) {
                is ResultType.Success -> {
                    _regitro.value = registrer.data as? Registro
                }

                is ResultType.Error -> {
                    _errorMessage.postValue(
                        ErrorResponse(
                            code = registrer.code,
                            message = registrer.message
                        )
                    )
                }
            }
        }
    }

}