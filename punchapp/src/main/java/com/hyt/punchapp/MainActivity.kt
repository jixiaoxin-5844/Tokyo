package com.hyt.punchapp

import android.app.SearchManager
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.view.MotionEvent
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.blankj.utilcode.util.ToastUtils
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.punchapp.service.ProcessService
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
/*
    var stub: IUserManager? = null

    //Aidl跨进程通信
    private val connection1 = object :ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            stub = IUserManager.Stub.asInterface(service)
            stub!!.getUserInfo("",2)
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            stub = null
        }

    }*/

    override fun initViews() {

        val intent = Intent(this,ProcessService::class.java)

        binding.text.setOnClickListener {
            L.d("ProcessService","启动")
           // startService(intent)
            // bindService(intent,connection1, Context.BIND_AUTO_CREATE)
        }

        binding.btn.setOnClickListener {
           /* val a = AppKv.getShowLoginDialog()
            L.d("Hyttt","当前值$a")
            AppKv.setShowLoginDialog(a + 1)*/
        }

        binding.aaa.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

                ToastUtils.showLong("选中状态${isChecked}")
            }
        })

    }

}