package com.practica.turismoapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.Foto
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.Turismo
import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.data.User
import com.practica.turismoapp.repository.RepositoryTurismoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel() : ViewModel() {

    val repositoryTurismo = RepositoryTurismoImpl()

    private var _turismoGlam = MutableLiveData<TurismoGlam>()
    val turismoGlam: LiveData<TurismoGlam> = _turismoGlam

    private var _errorMessage = MutableLiveData<Boolean>()
    val errorMessage: LiveData<Boolean> = _errorMessage


    fun getLugares() {
        viewModelScope.launch {
            when (val listPlaces = withContext(Dispatchers.IO){ repositoryTurismo.getListPlaces() }) {
                is ResultType.Success -> {
                    _turismoGlam.value = listPlaces.data as TurismoGlam
                }
                is ResultType.Error -> _errorMessage.postValue(true)
            }
        }
    }

    private fun miProveedorInterno() =
         TurismoGlam(
            Glamping = listOf(
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Guyra",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalUno.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Nahuel",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalDos.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                ),
                Turismo(
                    3,
                    "Glamping Otro Lugar",
                    "",
                    "Nuestros domos cuentan con 4 camas individuales, contando con baño incluido con ducha, salamandra para acondicionar en invierno y todas las comodidades que necesites para tu estadia",
                    "http://149.50.140.123/uploads/files/principalTres.jpg",
                    "Guyra es un complejo hotelero único en su tipo, ubicado en los impresionantes Esteros del Batel. Nuestro objetivo es brindarte una experiencia inolvidable en medio de la naturaleza, ofreciéndote una amplia gama de actividades para que puedas disfrutar al máximo de este hermoso lugar. ",
                    "https://www.instagram.com/glamping_guyra/",
                    listOf(
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenUno.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenDos.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenTres.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCuatro.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenCinco.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSeis.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraImagenSiete.png"),
                        Foto("http://149.50.140.123/uploads/files/GuyraItemOcho.png")
                    )
                )
            )
        )
    }
