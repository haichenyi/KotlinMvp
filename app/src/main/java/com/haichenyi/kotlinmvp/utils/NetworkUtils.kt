package com.haichenyi.kotlinmvp.utils

import android.content.Context
import android.net.ConnectivityManager


/**
 * @Author haichenyi
 * @Desc 网络判断工具类
 * @Date 2019/7/29-09:16
 * @Home haichenyi.com
 */
object NetworkUtils {
    /**
     * 判断是否有网：true有网，false没网
     * ping的方式实现，防止有的wifi链接需要验证才能上网
     */
    fun hasNetwork(): Boolean = Runtime.getRuntime().exec("ping -c 1 -w 1 www.baidu.com").waitFor() == 0

    /**
     * 是否有网
     */
    fun hasNetwork(context: Context): Boolean {
        val netState = false
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        if (null != connectivity) {
            val conn = connectivity as ConnectivityManager
            val netInfo = conn.activeNetworkInfo
            if (null != netInfo) {
                return netInfo.isConnected
            }
        }
        return netState
    }
}