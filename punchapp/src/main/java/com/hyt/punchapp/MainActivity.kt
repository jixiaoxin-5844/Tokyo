package com.hyt.punchapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.punchapp.service.TestService
import com.hyt.tool_lib.utils.L

class MainActivity : BaseActivity<ActivityMainBinding>() {

  //  private val TAG = "Hyttt"

    lateinit var testService: TestService.TestBinder

    private val connection = object : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            testService = service as TestService.TestBinder
            L.d("TestService","onServiceConnected")
            testService.startDownload()
            testService.getProgress()
        }

        override fun onServiceDisconnected(name: ComponentName?) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.baidu.com")
        }*/
        //设置具体包名启动
        //intent.setClassName(packageName,"com.hyt.punchapp.MainActivity2")

        val intent = Intent(this,TestService::class.java)

        binding.text.setOnClickListener {
            L.d("TestService","启动")
            bindService(intent,connection, Context.BIND_AUTO_CREATE)
        }

        binding.btn.setOnClickListener {
            unbindService(connection)
        }



    }


}