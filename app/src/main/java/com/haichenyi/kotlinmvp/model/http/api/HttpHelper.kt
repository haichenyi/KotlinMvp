package com.haichenyi.kotlinmvp.model.http.api

import com.haichenyi.kotlinmvp.model.bean.CodeBean
import io.reactivex.Flowable

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:17
 * @Home haichenyi.com
 */
interface HttpHelper {
    /**
     * 获取注册验证码.
     *
     * @param accountName 手机号
     * @return CodeBean
     */
    fun getRegisterCode(accountName: String): Flowable<CodeBean>
}