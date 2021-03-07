package com.hyt.punchapp.view.activity.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author : Hyt
 * time : 2021/03/07
 * version : 1.0
 *
 */
class MyObserver: LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop(){

    }

}