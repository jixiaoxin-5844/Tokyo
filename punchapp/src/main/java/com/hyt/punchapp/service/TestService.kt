package com.hyt.punchapp.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.hyt.tool_lib.utils.L

/**
 * author : Hyt
 * time : 2021/03/03
 * version : 1.0
 *
 */
class TestService: Service() {

    private val TAG = "TestService"

    private val testBinder = TestBinder()

    override fun onBind(intent: Intent): IBinder {
        L.d(TAG,"TestService - onBind")
        return testBinder
    }

    override fun onCreate() {
        super.onCreate()
        L.d(TAG,"TestService - onCreate")

        //创建通知栏，让自己成为前台Service
        //startForeground()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        L.d(TAG,"TestService - onStartCommand")

        //处理完执行了逻辑后，调用关闭
        //stopSelf()


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        L.d(TAG,"TestService - onDestroy")
    }

    class TestBinder: Binder(){

        private val TAG = "TestService"

        fun startDownload(){
            Log.d(TAG,"TestBinder - startDownload")
        }

        fun getProgress(){
            L.d(TAG,"TestBinder - getProgress")
        }

    }

}