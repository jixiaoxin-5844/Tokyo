package com.hyt.punchapp.view.activity.main

import android.content.*
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.hyt.base_lib.base.BaseActivity
import com.hyt.base_lib.utils.ActivityUtils
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.punchapp.lifecycle.KtxHandler
import com.hyt.punchapp.service.TestService
import com.hyt.punchapp.view.MainActivity2
import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

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

        }

        binding.btn.setOnClickListener {


        }



    }


}