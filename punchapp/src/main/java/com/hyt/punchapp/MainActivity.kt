package com.hyt.punchapp

import android.os.Bundle
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.tencent.bugly.crashreport.CrashReport

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding

       // CrashReport.testJavaCrash()

    }
}