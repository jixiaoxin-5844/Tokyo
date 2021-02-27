package com.hyt.punchapp

import android.Manifest
import android.os.Bundle
import com.hyt.base_lib.base.BaseActivity
import com.hyt.base_lib.interfaceA.InformListener
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.tool_lib.utils.L

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding

       // CrashReport.testJavaCrash()

        val map = mapOf<String, Int>(Pair("a",2))
        L.d("Hyttt","打印")
        for ((key, value) in map) {
          L.d("Hyttt",key + value)
        }
        map["a"]


        val hashMapOf = hashMapOf(Pair("a", 2))
        hashMapOf.get("")

        permissionX(object : InformListener {
            override fun onSucceed() {

            }

            override fun onFailure() {

            }

        },Manifest.permission.WRITE_EXTERNAL_STORAGE)



    }
}