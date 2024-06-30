package com.practica.turismoapp

import com.practica.turismoapp.data.Turismo


/*
Las const y las val son prácticamente lo mismo: valores que no se pueden cambiar.
La diferencia entre estas dos es: el valor de const se determina en el tiempo de compilación
y el valor de val se determina en tiempo de ejecución.
*****************************************************************************************************
* Comprensión const val y objetos complementarios
En Kotlin, la constpalabra clave se utiliza para definir constantes en tiempo de compilación.
*  Estas constantes deben tener un valor conocido en tiempo de compilación y no se pueden cambiar
* durante el tiempo de ejecución. La valpalabra clave se utiliza para declarar propiedades de solo
* lectura en Kotlin.
* ***************************************************************************************************
Los objetos complementarios en Kotlin son objetos que están vinculados a una clase y se puede
*  acceder a ellos sin una instancia de la clase. Se definen dentro de la clase usando el
* companion object bloque. Las const val declaraciones dentro de un objeto complementario están
*  asociadas con la clase misma y se puede acceder a ellas directamente sin una instancia de la clase.
*/

object Constants {

    var URL_BASE:String = "http://149.50.140.123/"

    var traspasoDeTurismo: Turismo? = null

}