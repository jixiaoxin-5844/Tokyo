package com.hyt.punchapp

import com.hyt.base_lib.base.BaseApp
import com.tencent.bugly.crashreport.CrashReport

class App: BaseApp() {

    override fun onCreate() {
        super.onCreate()


        //bug ly
        val userStrategy = CrashReport.UserStrategy(this).apply {
            appChannel = BuildConfig.FLAVOR
            appVersion = BuildConfig.VERSION_NAME
            appPackageName = BuildConfig.APPLICATION_ID
        }
        CrashReport.initCrashReport(this,userStrategy)
    }
}