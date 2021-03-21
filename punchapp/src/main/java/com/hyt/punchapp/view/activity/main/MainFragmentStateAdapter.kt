package com.hyt.punchapp.view.activity.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hyt.punchapp.view.fragment.HomeFragment
import com.hyt.punchapp.view.fragment.MineFragment

/**
 * author : Hyt
 * time : 2021/03/20
 * version : 1.0
 *
 */
class MainFragmentStateAdapter (
    fm: FragmentManager, lifecycle: Lifecycle, private val list:List<Int>
) : FragmentStateAdapter(fm, lifecycle) {

    private val createdIds = hashSetOf<Long>()
    //******************
    private val fid1 = 111.toLong()
    private val fid2 = 222.toLong()
    private val ids: ArrayList<Long>
        get() = arrayListOf(fid1, fid2)

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        val id = ids[position]
        createdIds.add(id)
        when(position){
            0 ->{
                return HomeFragment()
            }
            1 ->{
                return MineFragment()
            }
        }
        return MineFragment()
    }

    override fun getItemId(position: Int): Long {
        return ids[position]
    }

    override fun containsItem(itemId: Long): Boolean {
        return createdIds.contains(itemId)
    }

}