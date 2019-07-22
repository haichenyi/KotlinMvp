package com.haichenyi.kotlinmvp.third.livedata

import androidx.lifecycle.LiveData

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/19-17:20
 * @Home haichenyi.com
 */
class BaseLiveData<T> : LiveData<T>() {

    /**
     * 回调在主线程
     */
    fun callBackUi(t: T) {
        postValue(t)
    }

    /**
     * 回调在当前线程
     */
    fun callBack(t: T) {
        value = t
    }
}