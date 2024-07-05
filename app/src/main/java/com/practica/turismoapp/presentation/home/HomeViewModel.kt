package com.practica.turismoapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.repository.RepositoryTurismo.Companion.pegadaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(): ViewModel() {

    private var _turismoGlam = MutableLiveData<TurismoGlam>()
    val turismoGlam: LiveData<TurismoGlam> = _turismoGlam


    fun getLugares() {
        viewModelScope.launch {
            val miRest = withContext(Dispatchers.IO){ pegadaRepository() }
            if (miRest.isSuccessful) {
                _turismoGlam.value = miRest.body()
            }

        }
    }
}