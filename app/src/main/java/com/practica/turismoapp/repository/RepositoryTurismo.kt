package com.practica.turismoapp.repository


import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.network.APIService
import com.practica.turismoapp.network.DataSource.Companion.retrofit
import retrofit2.Response

class RepositoryTurismo{

    companion object{
        suspend fun pegadaRepository(): Response<TurismoGlam>{
            val result = retrofit.create(APIService::class.java).getDatosTurismo()
            return result
        }
   /*
   suspend fun pegadaRepositoryDos(): Response<TurismoGlam>{
            val result = retrofit.create(APIService::class.java).getDatosTurismo()
            return result
        }
    }
   */
}  }