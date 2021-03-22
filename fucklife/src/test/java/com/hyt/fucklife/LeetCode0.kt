package com.hyt.fucklife

import org.junit.Test
import java.util.*

class LeetCode0 {

    //斐波那契数列 一个数等于前两个数的和
    //  0 1  1  2 3 5 8

    //写一个函数，输入x  输出斐波那契数列中第x位的元素
    @Test
    fun main(){
        val check = check(6)
        println("输出 check$check")
    }

    private fun check(x: Int): Int{
        println("当前x:$x")
        if(x == 0){
            return 0
        }
        if(x == 1){
            return 1
        }
        return check(x - 1) + check(x - 2)
    }

    //输入两个字符串，用动态规划的方法，求解出最大公共子串


    //二分查找
    @Test
    fun twoFind(){
        val arrayOf = arrayOf(1, 2, 5, 9, 15, 23, 30)
        val findNum = 23

        var middle = 0
        var low = 0
        var high = arrayOf.size - 1
        var isfind = -1

        while (low <= high){
            middle = (high + low)/2
            if(arrayOf[middle] == findNum){
                isfind = middle
                break
            }else if(arrayOf[middle] > findNum){
                //说明改数在 low - middle之间
                high = middle - 1
            }else{
                //说明改数在 middle - high 之间
                low = middle + 1
            }
        }

        if(isfind == -1){
            println("该数不在数组中")
            //该数不在数组中
        }else{
            println("该数的下标为$isfind")
        }

    }

    //给定一棵树，按照层次顺序遍历打印这棵树
    fun aa(){
        val treeMap = TreeMap<String, Int>()

        treeMap.put("",2)
    }

    //找出数组中出现次数超过一半的元素
    @Test
    fun tee(){
        val arrayOf = arrayOf(1, 2, 1, 1, 1, 23, 30)
        var result = arrayOf[0]
        var times = 1
        for (i in 1 until arrayOf.size){
            if(arrayOf[i] != result){
                times--
            }else{
                times ++
            }
            if(times == -1){
                times = 1
                result = arrayOf[i]
            }
        }
        println(result)

    }



}