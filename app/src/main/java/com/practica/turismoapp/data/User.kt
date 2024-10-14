package com.practica.turismoapp.data

data class User(
    var user: String = "",
    var password: String = "",
    var place: String = "",
    var enabled: Boolean = false)

data class Registro(
    var user: String = "",
    var password: String = "",
    var place: String = "",
    var phone: String = "",
    var email: String ="",
    var enabled: Boolean = false)


