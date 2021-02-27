package com.hyt.base_lib.base

import android.app.Application
import android.content.Context
import com.tencent.mmkv.MMKV


import kotlin.properties.Delegates

open class BaseApp: Application() {

    companion object {
        @JvmStatic
        var CONTEXT: Context by Delegates.notNull()
    }


    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        MMKV.initialize(this)
    }
}