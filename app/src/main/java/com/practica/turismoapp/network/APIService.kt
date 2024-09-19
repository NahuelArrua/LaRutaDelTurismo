package com.practica.turismoapp.network


import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.data.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @GET("api/glamping/v1")
    suspend fun getDatosTurismo(): TurismoGlam

    @POST("auth")
    suspend fun getLogin(@Body user: User): User
}
