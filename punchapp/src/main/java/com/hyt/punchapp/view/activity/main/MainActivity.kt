package com.hyt.punchapp.view.activity.main

import androidx.lifecycle.ViewModelProvider
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.tool_lib.utils.L
import java.lang.StringBuilder

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModel: MainViewModel


    override fun initViews() {
        viewModel = ViewModelProvider(this, MainViewModelFactory(1))[MainViewModel::class.java]

        binding.text.setOnClickListener {

        }

        binding.btn.setOnClickListener {

        }

        val str = "the sky is blue"
        L.d("Hyttt","倒叙前字符串$str")
        //反转
        val stack = Stack<String>()
        str.split(" ").forEach {
            L.d("Hyttt","入栈$it")
            stack.push(it)
        }

        val stringBuilder = StringBuilder()
        stack.forEachTop {
            stringBuilder.append(it).append(" ")
        }

        L.d("Hyttt","倒叙后字符串$stringBuilder")


    }


}