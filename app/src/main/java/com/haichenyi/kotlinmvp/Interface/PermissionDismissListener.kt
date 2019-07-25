package com.haichenyi.kotlinmvp.Interface

/**
 * @Author haichenyi
 * @Desc  消失回调
 * @Date 2019/7/24-10:27
 * @Home haichenyi.com
 */
interface PermissionDismissListener {
    /**
     * 取消
     */
    fun onCancel()

    /**
     * 去设置
     */
    fun onSetting()
}