package com.practica.turismoapp.data

sealed class ResultType {
    data class Success(val data: TurismoGlam): ResultType()
    data class Error(val code: Int, val message: String): ResultType()
}