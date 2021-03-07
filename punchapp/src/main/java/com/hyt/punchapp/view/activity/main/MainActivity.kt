package com.hyt.punchapp.view.activity.main

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.R
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.punchapp.service.ProcessService
import com.hyt.punchapp.service.TestService
import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {

  //  private val TAG = "Hyttt"
    private lateinit var viewModel: MainViewModel

   // private val viewModel1 by viewModels<MainViewModel>()

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
        viewModel = ViewModelProvider(this,MainViewModelFactory(1))[MainViewModel::class.java]




        lifecycle.addObserver(MyObserver())

  /*      with(binding.recyclerView){
            layoutManager = LinearLayoutManager(this@MainActivity)
            val mainRVAdapter = MainRVAdapter(this@MainActivity)
            adapter = mainRVAdapter

            mainRVAdapter.setList(     mutableListOf("dsdds","",""))
            mainRVAdapter.setItemListener(object : OnRVListener{
                override fun onClick(position: Int) {

                    ToastUtils.showLong("单击了 position:$position")
                }

            })
        }*/




        val intent = Intent(this,ProcessService::class.java)



        binding.text.setOnClickListener {


            val myHandler = MyHandler(Looper.getMainLooper())

            val message = Message()
            message.arg1 = 1
           // myHandler.sendMessage(message)

            lifecycleScope.launch (Dispatchers.IO){
                Looper.prepare()
                val myHandler0 = MyHandler(Looper.myLooper()!!)

                val message2 = Message()
                message2.arg1 = 2
                myHandler0.sendMessage(message2)
                Looper.loop()
            }

            // startService(intent)
            // bindService(intent,connection1, Context.BIND_AUTO_CREATE)
        }

        binding.btn.setOnClickListener {
           /* val a = AppKv.getShowLoginDialog()
            L.d("Hyttt","当前值$a")
            AppKv.setShowLoginDialog(a + 1)*/
        }




    }

    inner class MyHandler(looper: Looper): Handler(looper){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            L.d("Hytttt","接收消息,threadName:${Thread.currentThread().name}")
        }

        override fun sendMessageAtTime(msg: Message, uptimeMillis: Long): Boolean {
            return super.sendMessageAtTime(msg, uptimeMillis)
        }
    }


}