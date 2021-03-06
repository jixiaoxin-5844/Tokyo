package com.hyt.punchapp.view.activity.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * author : Hyt
 * time : 2021/03/07
 * version : 1.0
 * 使用方法
 *   viewModel = ViewModelProvider(this, MainViewModelFactory(1))[MainViewModel::class.java]
 */
class MainViewModelFactory(private val result: Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(/*result*/) as T
    }
}