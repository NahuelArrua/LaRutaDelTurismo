package com.practica.turismoapp.network


import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.data.TurismoGlam
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @GET("api/glamping/v1")
    suspend fun getDatosTurismo(): Response<TurismoGlam>

 /*
    @POST("api/glamping/v1")
    suspend fun postDatosTurismo(): Response<TurismoGlam>
     */
}
