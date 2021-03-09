package com.hyt.punchapp.view.activity.splash

import android.content.Intent
import com.hyt.base_lib.base.BaseActivity
import com.hyt.base_lib.utils.ActivityUtils
import com.hyt.punchapp.databinding.ActivitySplashBinding
import com.hyt.punchapp.service.ProcessService
import com.hyt.punchapp.view.activity.main.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>() {


    override fun initViews() {
        //打开后台不同进程服务
        startService(Intent(this,ProcessService::class.java))

        //启动MainActivity
        ActivityUtils.startActivity<MainActivity>(this){}
        finish()

    }
}