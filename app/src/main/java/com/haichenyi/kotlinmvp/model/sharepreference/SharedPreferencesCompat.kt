package com.haichenyi.kotlinmvp.model.sharepreference

import android.content.SharedPreferences

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * @Author haichenyi
 * @Desc 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
 * 所有的commit操作使用了SharedPreferencesCompat.apply进行了替代
 * 目的是尽可能的使用apply代替commit首先说下为什么，因为commit方法是同步的，
 * 并且我们很多时候的commit操作都是UI线程中，毕竟是IO操作，尽可能异步；
 * 所以我们使用apply进行替代，apply异步的进行写入
 * @Date 2019/7/23-15:07
 * @Home haichenyi.com
 */
object SharedPreferencesCompat {
    private val APPLY_METHOD = findApplyMethod()

    /**
     * 反射查找apply的方法
     *
     * @return apply方法
     */
    private fun findApplyMethod(): Method? {
        try {
            val clz = SharedPreferences.Editor::class.java
            return clz.getMethod("apply")
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        }

        return null
    }

    /**
     * 如果找到则使用apply执行，否则使用commit
     *
     * @param editor editor
     */
    internal fun apply(editor: SharedPreferences.Editor) {
        try {
            if (APPLY_METHOD != null) {
                APPLY_METHOD.invoke(editor)
                return
            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        }
        editor.commit()
    }
}
