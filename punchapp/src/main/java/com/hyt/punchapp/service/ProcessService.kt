package com.hyt.punchapp.service

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context

import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import com.hyt.base_lib.base.EventBusDataBean
import com.hyt.punchapp.ProcessReceiver
import com.hyt.punchapp.model.kv.AppKv
import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class ProcessService : Service() {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    private val TAG = "Hyttt"

    //aidl
    /*val stub = object :IUserManager.Stub(){
        override fun getUserInfo(name: String?, age: Int) {
            L.d(TAG,"当前线程name:${Thread.currentThread().name}")
        }
    }*/

    override fun onBind(intent: Intent): IBinder? {
       // return stub
        return null
    }

    override fun onCreate() {
        super.onCreate()
        L.d(TAG,"ProcessService - onCreate...")

        //注册广播
        val intentFilter = IntentFilter().apply {
            addAction(ServiceAction.ProcessService)
        }
         val processReceiver = ProcessReceiver()
        registerReceiver(processReceiver,intentFilter)

        //发送广播
      /*  val intent1 = Intent(ServiceAction.ProcessService)
        intent1.setPackage(packageName)
        intent1.putExtra("DATA","嘿嘿嘿")
        sendBroadcast(intent1)*/
    }

    override fun onDestroy() {
        super.onDestroy()
        if(scope.isActive){
            scope.cancel()
        }
    }

    inner class ProcessReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val stringExtra = intent?.getStringExtra("DATA")
            L.d(TAG,"ProcessService ->Process: onReceive 接收的数据:${stringExtra}")
            L.d(TAG,"ProcessService ->当前ThreadName:${Thread.currentThread().name}")
            scope.launch(Dispatchers.IO) {
            L.d(TAG,"ProcessService ->当前ThreadName:${Thread.currentThread().name}")

            }
        }

    }
}