package com.hyt.punchapp.service

import android.app.Service

import android.content.Intent
import android.os.IBinder
import com.hyt.punchapp.model.kv.AppKv
import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.*

class ProcessService : Service() {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    private val TAG = "Hyttt"

    val stub = object :IUserManager.Stub(){
        override fun getUserInfo(name: String?, age: Int) {

            L.d(TAG,"当前线程name:${Thread.currentThread().name}")
        }

    }


    /*private val binder = object : IUserManager.Stub(){

    }*/
    override fun onBind(intent: Intent): IBinder {
        return stub
    }

    override fun onCreate() {
        super.onCreate()
        L.d(TAG,"ProcessService - onCreate...")
       /* scope.launch {
            while (true){
                delay(2000)
                val nowData = AppKv.getShowLoginDialog()
                L.d(TAG,"ProcessService - 当前值$nowData")
            }
        }*/

    }

    override fun onDestroy() {
        super.onDestroy()
        if(scope.isActive){
            scope.cancel()
        }
    }
}