package com.hyt.punchapp.view.fragment

import android.view.LayoutInflater
import com.hyt.base_lib.base.BaseFragment
import com.hyt.punchapp.R
import com.hyt.punchapp.databinding.FragmentHomeBinding
import com.hyt.tool_lib.utils.L

class HomeFragment: BaseFragment<FragmentHomeBinding>() {
    override fun initViews() {
    /*    val width = binding.root.width

        val width1 = activity?.window?.decorView?.width
        val height1 = activity?.window?.decorView?.height
        L.d("Hyttt","width1:$width1")
        L.d("Hyttt","height1:$height1")
        if(null != width1 && null != height1){
            binding.moveBtn.setWH(width1,height1)
        }*/


        binding.root.post {
            val rootWidth = binding.root.width
            val rootHeight = binding.root.height
            L.d("Hyttt2","rootWidth:$rootWidth , rootHeight:$rootHeight")
            binding.moveBtn.setWH(rootWidth,rootHeight)
        }

    }
}