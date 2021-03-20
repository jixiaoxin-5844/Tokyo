package com.hyt.punchapp.view.activity.main

import java.util.*

/**
 * author : Hyt
 * time : 2021/03/20
 * version : 1.0
 *
 */
class Stack<E> {

    private val linkedList = LinkedList<E>()

    //压栈
    fun push(value: E){
        linkedList.addFirst(value)
    }

    //出栈
    fun pop(): E{
        return linkedList.removeFirst()
    }

    fun size():Int{
        return linkedList.size
    }

    //遍历 从栈顶 到 栈底
    fun forEachTop(action: (E) -> Unit): Unit{
        if(linkedList.size <= 0){
            return
        }
        for (element in linkedList) action(element)
    }

    //遍历 从栈底 到 栈顶
    fun forEachBottom(action: (E) -> Unit): Unit{
        if(linkedList.size <= 0){
            return
        }
        for (index in (linkedList.size -1 ) downTo 0)
            action(linkedList[index])
    }

}