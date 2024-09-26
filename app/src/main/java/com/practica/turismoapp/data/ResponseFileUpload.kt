package com.practica.turismoapp.data

data class ResponseFileUpload(
    val fileName: String? = null,
    val fileDownloadUri: String? = null,
    val fileType: String? = null,
    val fileSize: Int = 0
)
