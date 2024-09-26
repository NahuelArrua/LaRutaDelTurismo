package com.practica.turismoapp.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.ResponseFileUpload
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.User
import com.practica.turismoapp.repository.RepositoryTurismoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody

class LoginViewModel : ViewModel() {

    val repositoryTurismo = RepositoryTurismoImpl()

    private var _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    private var _errorMessage = MutableLiveData<Boolean>()
    val errorMessage: LiveData<Boolean> = _errorMessage


    fun login(user: User) {
        viewModelScope.launch {
            when (val registrer =
                withContext(Dispatchers.IO) { repositoryTurismo.getLogin(user) }) {
                is ResultType.Success -> {
                    _user.value = registrer.data as User?
                }

                is ResultType.Error -> _errorMessage.postValue(true)
            }
        }
    }

    fun uploadFile(archivoASubir: MultipartBody.Part?) {
        viewModelScope.launch {
            when (
            val subirImagen = withContext(Dispatchers.IO) { repositoryTurismo.uploadFile(archivoASubir) }){
            is ResultType.Success ->{
            val addresImage = subirImagen.data as ResponseFileUpload
            //Fixme:  Aca si subio la imagen y te devuele el resultado
            //Fixme:  para leer donde quedo la imagen es como cualquier dataclass
        }
                is ResultType.Error ->{
                    //Fixme:  Aca mensaje de que no cargo la imagen
                }
        }
        }
    }



}