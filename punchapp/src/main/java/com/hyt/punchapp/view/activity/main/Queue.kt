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
    fun push(value: E){
        linkedList.add(value)
    }

    //出列
    fun pop(): E{
        return linkedList.removeFirst()
    }

    fun size():Int{
        return linkedList.size
    }

    //遍历 从头到尾
    fun forEach(action: (E) -> Unit): Unit{
        for (element in linkedList) action(element)
    }

}