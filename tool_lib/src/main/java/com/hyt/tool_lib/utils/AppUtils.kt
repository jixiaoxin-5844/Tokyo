package com.hyt.tool_lib.utils

import android.content.Context
import android.content.res.Configuration

/**
 * author : Hyt
 * time : 2021/03/07
 * version : 1.0
 *
 */
object AppUtils {

    //当前是否是黑暗模式主题
    fun isDarkTheme(context: Context):Boolean{
        val flag = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return flag == Configuration.UI_MODE_NIGHT_YES
    }

}