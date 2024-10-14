package com.practica.turismoapp

import com.google.gson.annotations.SerializedName
import com.practica.turismoapp.data.Foto
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.data.TurismoGlam

object Constants {

    val prod = "http://149.50.140.123/"

    val preprod = "http://149.50.140.123:81/"

    var URL_BASE:String = preprod

    var traspasoDeTurismo: Turismo? = null
    var contactNumber = "3794023483"

    var glampingLoad: Turismo? = null

    var grillaGlamping: TurismoGlam? = null

    var listaDeImagenes = mutableListOf<String>("","","","","","","","","")

//    fun cargarGlampingParaPOST(listaImagenes: List<String>) {
//        glampingChoto.apply {
//            Fotos = listaImagenes
//        }
//    }

}