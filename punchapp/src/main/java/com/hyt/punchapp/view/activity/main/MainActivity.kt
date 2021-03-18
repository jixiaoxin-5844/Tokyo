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


    override fun initViews() {
        viewModel = ViewModelProvider(this, MainViewModelFactory(1))[MainViewModel::class.java]

        binding.text.setOnClickListener {

        }

        binding.btn.setOnClickListener {


        }


        val linkedList = LinkedList<String>()

        linkedList.add("1")
        linkedList.add("2")
        linkedList.add("3")
        linkedList.add("4")
        linkedList.add("5")

        //打印此时的链表
        linkedList.forEach {
            L.d("$it")
        }




    }


}