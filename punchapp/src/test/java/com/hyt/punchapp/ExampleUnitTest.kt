package com.hyt.punchapp

import org.junit.Test

import org.junit.Assert.*
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val lock = ReentrantReadWriteLock()
    private val readLock = lock.readLock()
    private val writeLock = lock.writeLock()

    private val list = mutableListOf(1,2,3,4,5,6)

    @Test
    fun addition_isCorrect() {

       // Thread{
            println("开始读取数据")
            for (i in 0 until 10000){
                if(list.size > i){
                    val list1 = getList(i)
                    println("读取到数据：$list1")
                }else{
                    println("无position为$i 的数据")
                }
            }
        //}.start()

        //Thread{
            println("开始写入数据")
            for (i in 0 until 10000){
                println("写入数据position:$i -> num:$i")
                addList(i,i)
            }
       // }.start()

    }


    fun addList(position:Int,num:Int){
        writeLock.lock()
        try {
            list.add(num)
        }finally {
            writeLock.unlock()
        }
    }

    fun getList(position:Int):Int{
        readLock.lock()
        try {
            return list[position]
        }finally {
            readLock.unlock()
        }
    }

}