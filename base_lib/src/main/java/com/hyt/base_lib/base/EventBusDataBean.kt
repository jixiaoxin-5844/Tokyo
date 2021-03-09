package com.hyt.base_lib.base

/**
 * author : Hyt
 * time : 2021/03/09
 * version : 1.0
 *
 */
class EventBusDataBean {
    companion object{
        const val LOGOUT = 1000    // 注销登录

    }


    private val eventId: Int  //事件id
    private lateinit var data: Any     //传输数据

    constructor(eventId: Int){
        this.eventId = eventId
    }
    constructor(eventId: Int,data :Any){
        this.eventId = eventId
        this.data = data
    }


    fun getEventId():Int{
        return eventId
    }

    fun getData():Any{
        if(::data.isInitialized){
            return data
        }
        return "无数据"
    }

}