package com.practica.turismoapp.presentation.selector

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practica.turismoapp.data.ResponseFileUpload
import com.practica.turismoapp.data.ResultType
import com.practica.turismoapp.data.TurismoGlam
import com.practica.turismoapp.repository.TurismoRepositoryImpl
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.format
import id.zelory.compressor.constraint.quality
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class SelectorViewModel(): ViewModel() {
    val repositoryTurismo = TurismoRepositoryImpl()

    var imagePart: MultipartBody.Part? = null

    private var _compartirEnabled = MutableLiveData<Boolean>(false)
    val compartirEnabled: LiveData<Boolean> = _compartirEnabled

    private var _fileUploaded = MutableLiveData<ResponseFileUpload>()
    val fileUploaded: LiveData<ResponseFileUpload> = _fileUploaded

    private var _errorMessage = MutableLiveData<Boolean>()
    val errorMessage: LiveData<Boolean> = _errorMessage


    fun takeFile(value: Boolean) {
        _compartirEnabled.postValue(value)
    }

    fun sendPhoto(imgPath: String, ctx: Context) {
        viewModelScope.launch {
            when (val subido = withContext(Dispatchers.IO){
                repositoryTurismo.uploadFile(getMultiPartFile(imgPath,ctx)) }) {
                is ResultType.Success -> {
                    _fileUploaded.value = subido.data as ResponseFileUpload
                }
                is ResultType.Error -> _errorMessage.postValue(true)
            }
        }
    }

    suspend fun getMultiPartFile(imgPath: String, ctx: Context): MultipartBody.Part {
          return imgPath.let { path ->
            val pictureFile = File(path)
            val compressImage = Compressor.compress(ctx, pictureFile) {
                quality(30)
                format(Bitmap.CompressFormat.JPEG)
            }
            val newNameFile = compressImage.name.lowercase()
                .replace(".jpg","")
                .replace(".png","")

            val requestBody = compressImage.asRequestBody("image/*".toMediaType())

            MultipartBody.Part.createFormData(
                "image",
                "$newNameFile.jpg",
                requestBody
            )
        }
    }
}