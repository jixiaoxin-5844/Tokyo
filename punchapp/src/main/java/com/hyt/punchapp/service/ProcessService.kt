package com.hyt.punchapp.service

import android.app.Service

import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import com.hyt.punchapp.model.kv.AppKv
import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.*

class ProcessService : Service() {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    private val TAG = "Hyttt"

    //aidl
    val stub = object :IUserManager.Stub(){
        override fun getUserInfo(name: String?, age: Int) {

            L.d(TAG,"当前线程name:${Thread.currentThread().name}")
        }

    }

    //message
    val handler = ProcessHandler(Looper.getMainLooper())



    /*private val binder = object : IUserManager.Stub(){

    }*/
    override fun onBind(intent: Intent): IBinder? {
       // return stub
        return null
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

    inner class ProcessHandler(looper: Looper) : Handler(looper){
        val MSG_0 = 0

        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val obtain = Message.obtain(msg)
            when(obtain.what){
                MSG_0 ->{

                }
            }

        }
    }
}