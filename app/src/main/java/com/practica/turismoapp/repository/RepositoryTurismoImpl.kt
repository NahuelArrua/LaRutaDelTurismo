package com.practica.turismoapp.repository


import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.network.APIService
import com.practica.turismoapp.network.DataSource.Companion.retrofit

class RepositoryTurismoImpl(
): RepositoryTurismo {

    override suspend fun getListPlaces(): ResultType {
        val myApi = retrofit.create(APIService::class.java)
        return try {
            val result = myApi.getDatosTurismo()
            ResultType.Success(result)

        }catch (e: Exception){
            ResultType.Error(400,"Error al acceder al Servidor")
        }
    }
}
