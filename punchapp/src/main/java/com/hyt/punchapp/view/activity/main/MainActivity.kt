package com.hyt.punchapp.view.activity.main

import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.tool_lib.utils.L
import java.lang.StringBuilder

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    override fun initViews() {
        initViewPager2()





    }

    private fun initViewPager2() {
        //动态创建，设置存储
        val listOf = listOf(3, 5)
        val mainFragmentStateAdapter =
            MainFragmentStateAdapter(supportFragmentManager, lifecycle, listOf)
        binding.viewPager2.adapter = mainFragmentStateAdapter

    }


}