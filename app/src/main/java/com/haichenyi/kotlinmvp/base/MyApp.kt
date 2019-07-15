package com.haichenyi.kotlinmvp.base

import android.app.Application
import com.haichenyi.kotlinmvp.utils.ToastUtils

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/15-10:17
 * @Home haichenyi.com
 */
class MyApp :Application(){

    override fun onCreate() {
        super.onCreate()
        ToastUtils.init(this)
    }
}