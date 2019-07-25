package com.haichenyi.kotlinmvp.model.http.api

import com.haichenyi.kotlinmvp.model.bean.IpBean
import io.reactivex.Flowable

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:17
 * @Home haichenyi.com
 */
interface HttpHelper {
    /**
     * 获取IP地址.
     *
     * @param accountName name
     * @return IpBean
     */
    fun getIp(accountName: String): Flowable<IpBean>
}