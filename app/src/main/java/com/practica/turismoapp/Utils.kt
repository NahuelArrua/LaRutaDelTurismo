package com.practica.turismoapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log


    fun writeMessage(activity: Activity, message: String) {
        try {
            val myMessageSupport: Uri = Uri.parse("https://wa.me/${Constants.contactNumber}?text=Aqui%20esta%20la%20imagen:%20${message}")
            val intent = Intent(Intent.ACTION_VIEW, myMessageSupport)
            activity.startActivity(intent)
        } catch (e: Exception) {
            Log.e("TAG", e.message.toString())
        } finally {
            activity.finish()
        }
    }