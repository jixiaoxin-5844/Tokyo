package com.hyt.punchapp.view.fragment

import com.blankj.utilcode.util.ToastUtils
import com.hyt.base_lib.base.BaseFragment
import com.hyt.punchapp.databinding.FragmentMineBinding

/**
 * author : Hyt
 * time : 2021/03/20
 * version : 1.0
 *
 */
class MineFragment: BaseFragment<FragmentMineBinding>() {
    override fun initViews() {
        binding.root.setOnClickListener {
            ToastUtils.showLong("root click")
        }
        binding.text.setOnClickListener {

            ToastUtils.showLong("text click")
        }

    }
}