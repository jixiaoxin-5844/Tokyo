package com.hyt.punchapp.view.activity.main

import java.util.*

/**
 * author : Hyt
 * time : 2021/03/20
 * version : 1.0
 *
 */
class Queue<E> {

    private val linkedList = LinkedList<E>()

    //入列
    fun offer(value: E){
        linkedList.offer(value)
    }

    //出列
    fun poll(): E?{
        return linkedList.poll()
    }

    //查看但不出列
    fun peek():E?{
        return linkedList.peek()
    }

    fun size():Int{
        return linkedList.size
    }

    //遍历 从头到尾 !!!全部取出
  /*  fun forEach(action: (E) -> Unit): Unit{
        for (element in linkedList) action(element)
    }*/

}