package com.hyt.punchapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.blankj.utilcode.util.ToastUtils

/**
 * author : Hyt
 * time : 2021/03/09
 * version : 1.0
 *
 */
class ProcessReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        ToastUtils.showLong("接收到广播")


    }
}