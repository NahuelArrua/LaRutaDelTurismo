package com.practica.turismoapp.presentation.selector

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.presentation.model.ErrorResponse
import com.practica.turismoapp.repository.TurismoRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UpLoadViewModel : ViewModel() {

    val repositoryTurismo = TurismoRepositoryImpl()

    private val _upLoad = MutableLiveData<Turismo?>()
    val upload: LiveData<Turismo?> = _upLoad

    private var _errorMessage = MutableLiveData<ErrorResponse>()
    val errorMessage: LiveData<ErrorResponse> = _errorMessage

    fun upLoad(turismoGlam: Turismo){
        viewModelScope.launch {
            when(val Upload = withContext(Dispatchers.IO){repositoryTurismo.saveGlamping(turismoGlam)}){
                is ResultType.Success ->{
                    _upLoad.value = Upload.data as Turismo
                }
                is ResultType.Error -> {
                    _errorMessage.postValue(
                        ErrorResponse(
                            code = Upload.code,
                            message = Upload.message
                        )
                    )
                }
            }
        }
    }

}