package com.haichenyi.kotlinmvp.model.http.api

import com.haichenyi.kotlinmvp.model.bean.IpBean
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
     * 获取IP地址.
     *
     * @param name name
     * @return IpBean
     */
    @GET(HttpProtocol.HTTP_GET_IP)
    fun getIp(@Query("ip") name: String): Flowable<HttpResult<IpBean>>
}