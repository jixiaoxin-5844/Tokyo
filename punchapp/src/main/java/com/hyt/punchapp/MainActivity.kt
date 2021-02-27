package com.hyt.punchapp

import android.os.Bundle
import com.hyt.base_lib.base.BaseBindingActivity
import com.hyt.punchapp.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}