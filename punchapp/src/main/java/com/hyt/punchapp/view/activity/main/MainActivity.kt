package com.hyt.punchapp.view.activity.main

import android.view.MotionEvent
import androidx.activity.viewModels
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.R
import com.hyt.punchapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel by viewModels<MainViewModel>()

    override fun initViews() {
        initViewPager2()
        initBottomBtn()





    }

    private fun initBottomBtn() {
        binding.btn0.setText("首页")
        binding.btn0.setImage(R.mipmap.logo_0)

        binding.btn1.setText("我的")
        binding.btn1.setImage(R.mipmap.logo_0)

        binding.btn0.setOnClickListener {
            binding.viewPager2.currentItem = 0
        }

        binding.btn1.setOnClickListener {
            binding.viewPager2.currentItem = 1
        }

    }

    private fun initViewPager2() {
        //动态创建，设置存储
        val listOf = listOf(3, 5)
        val mainFragmentStateAdapter =
            MainFragmentStateAdapter(supportFragmentManager, lifecycle, listOf)


        with(binding.viewPager2){
            adapter = mainFragmentStateAdapter
            isUserInputEnabled = false //设置不可滑动
        }

    }

/*    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }*/

}