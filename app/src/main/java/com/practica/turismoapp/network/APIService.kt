package com.practica.turismoapp.network


import com.practica.turismoapp.data.ResponseFileUpload
import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.data.User
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface APIService {
    @GET("api/glamping/v1")
    suspend fun getDatosTurismo(): TurismoGlam

    @POST("auth")
    suspend fun getLogin(@Body user: User): User

    @Multipart
    @POST("api/file/v1/uploadfile")
    suspend fun UpLoadFile(@Part file: MultipartBody.Part?): ResponseFileUpload


}
