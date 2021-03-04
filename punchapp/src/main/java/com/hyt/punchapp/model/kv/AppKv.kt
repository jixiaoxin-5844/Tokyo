package com.hyt.punchapp.model.kv

import com.tencent.mmkv.MMKV

object AppKv {
    private val appKv = MMKV.mmkvWithID("App")

    //未登录状态下，点击头像只弹出一次登录弹出，之后都进入用户信息页面
    fun setShowLoginDialog(has: Int){
        appKv.encode("App_ShowLoginDialog",has)
    }

    fun getShowLoginDialog():Int{
        return appKv.decodeInt("App_ShowLoginDialog",0)
    }


    //清除所有App信息
    fun clearAllAppKv(){
        appKv.clearAll()
    }

}