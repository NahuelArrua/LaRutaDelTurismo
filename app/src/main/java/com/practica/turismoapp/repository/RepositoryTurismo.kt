package com.practica.turismoapp.repository

import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.data.User
import retrofit2.Response

interface RepositoryTurismo {
    suspend fun getListPlaces(): ResultType
    suspend fun getLogin(user: User): ResultType
}