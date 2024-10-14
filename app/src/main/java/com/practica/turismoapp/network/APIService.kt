package com.practica.turismoapp.network


import com.practica.turismoapp.data.Registro
import com.practica.turismoapp.data.ResponseFileUpload
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.data.User
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface APIService {
    @GET("api/glamping/v1")
    suspend fun getDatosTurismo(): TurismoGlam

    @POST("api/glamping/v1")
    suspend fun saveGlamping(@Body turismoGlam: Turismo): Turismo

    @POST("auth")
    suspend fun getLogin(@Body user: User): User

    @Multipart
    @POST("api/file/v1/uploadFile")
    suspend fun uploadFile(@Part file: MultipartBody.Part?): ResponseFileUpload

    @POST("auth/register")
    suspend fun getRegister(@Body registro: Registro): Registro
}
