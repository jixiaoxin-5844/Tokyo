package com.hyt.punchapp.view

import androidx.lifecycle.lifecycleScope
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMain2Binding
import com.hyt.punchapp.lifecycle.KtxHandler
import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : BaseActivity<ActivityMain2Binding>() {


    override fun initViews() {


        val ktxHandler = KtxHandler(this)
        ktxHandler.sendEmptyMessage(2)

    }

}