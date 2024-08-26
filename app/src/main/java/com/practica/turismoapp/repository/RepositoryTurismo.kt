package com.practica.turismoapp.repository

import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.TurismoGlam
import retrofit2.Response

interface RepositoryTurismo {
    suspend fun getListPlaces(): ResultType
}