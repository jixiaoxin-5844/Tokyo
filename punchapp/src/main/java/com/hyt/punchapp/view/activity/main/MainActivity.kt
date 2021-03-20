package com.hyt.punchapp.view.activity.main

import androidx.lifecycle.ViewModelProvider
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    //  private val TAG = "Hyttt"
    private lateinit var viewModel: MainViewModel


    override fun initViews() {
        viewModel = ViewModelProvider(this, MainViewModelFactory(1))[MainViewModel::class.java]

        binding.text.setOnClickListener {

        }

        binding.btn.setOnClickListener {

        }


    }


}