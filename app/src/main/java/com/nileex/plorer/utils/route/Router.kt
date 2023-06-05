package com.nileex.plorer.utils.route

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

object Router {

    fun <T>routeOnPage(context: Context, clazz: Class<T>){
        context.startActivity(Intent(context, clazz))
    }

    fun onBack(context: Context){
        (context as AppCompatActivity).finish()
    }
}