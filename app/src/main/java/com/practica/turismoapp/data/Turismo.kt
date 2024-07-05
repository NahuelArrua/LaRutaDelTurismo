package com.practica.turismoapp.data


data class Turismo(
    var Id: Int = 0,
    var Lugares: String = "",
    var Provincia: String = "",
    var Servicios: String = "",
    var Imagen: String = "",
    var Descripcion: String = "",
    var RedesSociales: String = "",
    var Fotos: List<Foto>? = null
)

data class Foto(
    var imagen: String? = null
)


