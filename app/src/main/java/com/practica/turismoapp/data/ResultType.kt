package com.practica.turismoapp.data

sealed class ResultType {
    data class Success(val data: Any): ResultType()
    data class Error(val code: Int, val message: String): ResultType()
}