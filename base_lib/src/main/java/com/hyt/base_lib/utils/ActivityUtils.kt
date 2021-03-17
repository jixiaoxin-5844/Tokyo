package com.hyt.base_lib.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

//fun Activity.start<reified T>(context: Context) = ActivityUtils.startActivity<>(context)

object ActivityUtils {

    inline fun <reified T> startActivity(context: Context,block: Intent.() -> Unit){
        val intent = Intent(context,T::class.java)
        intent.block()
        context.startActivity(intent)
    }

    inline fun <reified T> getGenericType(){

    }
}