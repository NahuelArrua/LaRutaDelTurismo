package com.practica.turismoapp.repository

import com.practica.turismoapp.data.Registro
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.data.User
import com.practica.turismoapp.network.APIService
import com.practica.turismoapp.network.DataSource.Companion.retrofit
import okhttp3.MultipartBody

class TurismoRepositoryImpl(
): TurismoRepository {

    override suspend fun getListPlaces(): ResultType {
        val myApi = retrofit.create(APIService::class.java)
        return try {
            val turismoResting = myApi.getDatosTurismo()
            ResultType.Success(turismoResting)

        }catch (e: Exception){
            ResultType.Error(400,e.message.toString())
        }
    }

    override suspend fun getLogin(user: User): ResultType {
        val myApi = retrofit.create(APIService::class.java)
        return try {
            val turismoResting = myApi.getLogin(user)
            ResultType.Success(turismoResting)

        }catch (e: Exception){
            ResultType.Error(400,e.message.toString())
        }
    }

    override suspend fun uploadFile(file: MultipartBody.Part?): ResultType {
        val myApi = retrofit.create(APIService::class.java)
        return try {
            val turismoResting = myApi.uploadFile(file)
            ResultType.Success(turismoResting)
        }catch (e: Exception){
            ResultType.Error(400,e.message.toString())
        }
    }

    override suspend fun getRegister(user: Registro): ResultType {
        val myApy = retrofit.create(APIService::class.java)
        return try {
            val user = myApy.getRegister(user)
            ResultType.Success(user)
        }catch (e:Exception){
            ResultType.Error(400, e.localizedMessage)
        }
    }


    suspend fun saveGlamping(turismoGlam: Turismo): ResultType{
        val myApy = retrofit.create(APIService::class.java)
        return try {
            val turismoGlam = myApy.saveGlamping(turismoGlam)
            ResultType.Success(turismoGlam)
        }catch (e:Exception){
            ResultType.Error(400, e.localizedMessage)
        }
    }

}
