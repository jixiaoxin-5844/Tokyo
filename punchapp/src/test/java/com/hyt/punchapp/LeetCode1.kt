package com.hyt.punchapp

import com.hyt.tool_lib.utils.L
import kotlinx.coroutines.delay
import org.junit.Test

class LeetCode1 {

    /*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，
    并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
你可以按任意顺序返回答案。*/
    //两数之和 - LeetCode 第一题
    @Test
    fun twoSum(){
        val nums = intArrayOf(2, 7, 11, 15)
        val indexs = IntArray(2)
        val hashMap = HashMap<Int, Int>()
        val target = 18
        for (i in nums.indices){
            if(hashMap.containsKey(nums[i])){
                indexs[0] = i
                indexs[1] = hashMap[nums[i]]!!
                break
            }
            hashMap.put(target-nums[i],i) // 16-0
        }
        println("下标分别是${indexs[0]},${indexs[1]}")
    }

}