package com.hyt.punchapp.bean;

// Declare any non-default types here with import statements
//手动导入
import com.hyt.punchapp.bean.UserBean;

interface IUserManager {

    //基本数据类型：int，long，boolean，float，double，String
    void hello(String aString);

    //非基本数据类型，传递对象
    void getUser(in UserBean userBean);//in 客户端->服务端


}