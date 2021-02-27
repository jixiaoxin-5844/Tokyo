package com.hyt.base_lib.interfaceA

interface InterfaceA {
}

//权限请求
interface InformListener {
    fun onSucceed() //同意
    fun onFailure() //拒绝
}