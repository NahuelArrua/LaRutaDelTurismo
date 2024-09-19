package com.practica.turismoapp.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(): ViewModel() {

    private var _screen: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)
    var screen: LiveData<Boolean> = _screen

    fun initCount() {
        viewModelScope.launch {
            delay(4000)
            _screen.value = true
        }
    }
}