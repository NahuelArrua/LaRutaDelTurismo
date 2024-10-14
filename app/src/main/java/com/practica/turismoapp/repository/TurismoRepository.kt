package com.practica.turismoapp.repository

import com.practica.turismoapp.data.Registro
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.User
import okhttp3.MultipartBody

interface TurismoRepository {
    suspend fun getListPlaces(): ResultType
    suspend fun getLogin(user: User): ResultType
    suspend fun uploadFile(file: MultipartBody.Part?) : ResultType
    suspend fun getRegister(registro: Registro): ResultType
}