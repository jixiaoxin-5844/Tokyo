package com.hyt.punchapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.blankj.utilcode.util.ToastUtils

class BootReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        ToastUtils.showLong("Boot Complete 接收到开机广播")

    }
}