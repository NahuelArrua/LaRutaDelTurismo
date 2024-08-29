package com.practica.turismoapp.network


import com.practica.turismoapp.data.TurismoGlam
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("api/glamping/v1")
    suspend fun getDatosTurismo(): TurismoGlam
}
