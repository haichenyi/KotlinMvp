package com.haichenyi.kotlinmvp.model.http.api

import com.haichenyi.kotlinmvp.model.bean.CodeBean
import com.haichenyi.kotlinmvp.model.http.HttpResult
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:17
 * @Home haichenyi.com
 */
interface HttpApi {
    /**
     * 获取注册验证码.
     *
     * @param phone 手机号
     * @return CodeBean
     */
    @GET(HttpProtocol.HTTP_REGISTER_GET_CODE)
    fun getRegisterCode(@Query("accountName") phone: String): Flowable<HttpResult<CodeBean>>
}