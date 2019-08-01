package com.haichenyi.kotlinmvp.model.sharepreference

import android.content.SharedPreferences

/**
 * @Author haichenyi
 * @Desc SharedPreferences的接口
 * @Date 2019/7/23-14:05
 * @Home haichenyi.com
 */
interface SpHelper {
    /**
     * 存放数据
     *
     * @param key 键
     * @param any 值
     */
    fun putValue(key: String, any: Any)

    /**
     * 存放map对象
     *
     * @param key 键
     * @param map map
     */
    fun putMap(key: String, map: Map<*, *>)

    /**
     * 获取存放的map对象
     *
     * @param key 键
     * @return Map对象
     */
    fun getMap(key: String): Map<*, *>?

    /**
     * 拿数据
     *
     * @param key           键
     * @param any 默认值
     * @return 值
     */
    fun getValue(key: String, any: Any): Any?

    /**
     * 自己定义的sp存数据
     *
     * @param sp     SharePreferences
     * @param key    键
     * @param any    值
     */
    fun putValue(sp: SharedPreferences, key: String, any: Any)

    /**
     * 自己定义的sp取数据
     *
     * @param sp     SharePreferences
     * @param key    键
     * @param any    默认值
     * @return 值
     */
    fun getValue(sp: SharedPreferences, key: String, any: Any): Any?
}