package com.hyt.punchapp.view.activity.main

import android.content.*
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.os.Message
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ToastUtils
import com.hyt.base_lib.base.BaseActivity
import com.hyt.base_lib.base.EventBusDataBean
import com.hyt.punchapp.R
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.punchapp.service.ProcessService
import com.hyt.punchapp.service.ServiceAction
import com.hyt.punchapp.service.TestService
import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus

class MainActivity : BaseActivity<ActivityMainBinding>() {

  //  private val TAG = "Hyttt"
    private lateinit var viewModel: MainViewModel

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

    override fun initViews() {
        viewModel = ViewModelProvider(this,MainViewModelFactory(1))[MainViewModel::class.java]


        binding.text.setOnClickListener {

            lifecycleScope.launch (Dispatchers.IO){
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(this@MainActivity,"红红火火恍恍惚惚",Toast.LENGTH_LONG).show()
                }
                //ToastUtils.showShort("红红火火恍恍惚惚")
            }


        }

        binding.btn.setOnClickListener {

        }


    }



}