package com.haichenyi.kotlinmvp.third.livedata

import android.util.ArrayMap

/**
 * @Author haichenyi
 * @Desc liveData管理类
 * @Date 2019/7/19-17:15
 * @Home haichenyi.com
 */
object LiveDataManager {
    private val liveDataMap = ArrayMap<String, BaseLiveData<*>>()
    private val listObjectMap = ArrayMap<Any, MutableList<String>>()

    fun <T> putLiveData(any: Any, key: String, liveData: BaseLiveData<T>) {
        val liveDataKey = any.toString().plus(key)
        putLiveData(liveDataKey, liveData)
        putObjectKey(any, liveDataKey)
    }

    /**
     * 存LiveData
     *
     * @param key      键
     * @param liveData 值
     * @param <T>      泛型
     */
    @Synchronized
    fun <T> putLiveData(key: String, liveData: BaseLiveData<T>) {
        if (null == liveDataMap[key]) {
            liveDataMap[key] = liveData
        }
    }

    /**
     * 根据any对象存放liveData
     *
     * @param any Any
     * @param key    key
     */
    private fun putObjectKey(any: Any, key: String) {
        var list = listObjectMap[any]
        if (null == list) {
            list = ArrayList()
            list.add(key)
        } else if (!list.contains(key)) {
            list.add(key)
        }
        listObjectMap[any] = list
    }

    /**
     * 获取BaseLiveData对象.
     *
     * @param <T> 数据类型
     * @param key 键
     * @return BaseLiveData
     */
    fun <T> getLiveData(key: String): BaseLiveData<T>? = liveDataMap[key] as BaseLiveData<T>

    /**
     *  是否已经注册过了
     */
    fun contain(key: String): Boolean {
        return null == liveDataMap[key]
    }

    /**
     * 移除LiveData对象
     */
    fun clean(any: Any) {
        val list = listObjectMap[any]
        if (null != list) {
            listObjectMap.remove(any)
        }
    }
}