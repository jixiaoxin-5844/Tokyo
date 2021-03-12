package com.hyt.punchapp.lifecycle

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.hyt.tool_lib.utils.L


/**
 * A custom Handler attached with the LifeCycle
 * Created by luyao
 * on 2019/8/6 9:34
 */
class KtxHandler(lifecycleOwner: LifecycleOwner,looper: Looper = Looper.getMainLooper()): Handler(looper), LifecycleObserver {

    private val mLifecycleOwner: LifecycleOwner = lifecycleOwner

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        removeCallbacksAndMessages(null)
        mLifecycleOwner.lifecycle.removeObserver(this)
    }
}