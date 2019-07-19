package com.haichenyi.kotlinmvp.base

import androidx.lifecycle.LifecycleOwner

/**
 * @Author haichenyi
 * @Desc v层基类
 * @Date 2019/7/15-17:23
 * @Home haichenyi.com
 */
interface BaseView : LifecycleOwner {
    fun showLoading()
    fun hideLoading()
}