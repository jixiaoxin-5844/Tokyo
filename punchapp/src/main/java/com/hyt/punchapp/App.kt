package com.hyt.punchapp

import com.blankj.utilcode.util.ProcessUtils
import com.hyt.base_lib.base.BaseApp
import com.hyt.tool_lib.utils.L
import com.tencent.bugly.crashreport.CrashReport

class App: BaseApp() {

    override fun onCreate() {
        super.onCreate()

        //多进程判断，退出初始化
        L.d("Hyttt","当前进程名:${ProcessUtils.getCurrentProcessName()}")

        //非主进程，不再初始化
        if(!ProcessUtils.isMainProcess()){
            return
        }
        L.d("Hyttt","初始化,进程名:${ProcessUtils.getCurrentProcessName()}")

        //bug ly
        val userStrategy = CrashReport.UserStrategy(this).apply {
            appChannel = BuildConfig.FLAVOR
            appVersion = BuildConfig.VERSION_NAME
            appPackageName = BuildConfig.APPLICATION_ID
        }
        CrashReport.initCrashReport(this,userStrategy)



    }
}