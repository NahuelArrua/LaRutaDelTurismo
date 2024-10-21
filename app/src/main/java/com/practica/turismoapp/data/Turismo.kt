package com.practica.turismoapp.data

import com.google.gson.annotations.SerializedName


data class Turismo(
    var Id: Int = 0,
    var Lugares: String = "",
    var Provincia: String = "",
    var Servicios: String = "",
    @SerializedName("Imagen")
    var ImagenPrincipal: String = "",
    var Descripcion: String = "",
    var RedesSociales: String = "",
    var Fotos: List<Foto>? = null
) {
    constructor(Id: List<Turismo>, Lugares: String, Provincia: String, Servicios: String, ImagenPrincipal: String, Descripcion: String, RedesSociales: String, Fotos: List<Foto>?) : this()
}

data class Foto(
    @SerializedName("Imagen")
    var ImagenDetalle: String? = null
)


