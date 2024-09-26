package com.practica.turismoapp.repository

import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.User
import com.practica.turismoapp.network.APIService
import com.practica.turismoapp.network.DataSource.Companion.client
import com.practica.turismoapp.network.DataSource.Companion.getUnsafeOkHttpClient
import com.practica.turismoapp.network.DataSource.Companion.retrofit

class RepositoryTurismoImpl(
): RepositoryTurismo {

    override suspend fun getListPlaces(): ResultType {
        val myApi = retrofit.create(APIService::class.java)
        return try {
            val caca = myApi.getDatosTurismo()
            ResultType.Success(caca)

        }catch (e: Exception){
            ResultType.Error(400,"Error al acceder al Servidor")
        }
    }

    override suspend fun getLogin(user: User): ResultType {
        val myApi = retrofit.create(APIService::class.java)
        return try {
            val caca = myApi.getLogin(user)
            ResultType.Success(caca)

        }catch (e: Exception){
            ResultType.Error(400,"Error al acceder al Servidor")
        }
    }

    override suspend fun uploadFile(file: MultipartBody.Part?): ResponseFileUpload {
        return APIService.uploadfile(file)
    }
}
