package com.haichenyi.kotlinmvp.model.http.api

import com.haichenyi.kotlinmvp.model.bean.IpBean
import com.haichenyi.kotlinmvp.model.http.MyRxUtils
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:19
 * @Home haichenyi.com
 */
class HttpReal @Inject constructor(private var httpApi: HttpApi) : HttpHelper {

    override fun getIp(accountName: String): Flowable<IpBean> =
        httpApi.getIp(accountName).compose(MyRxUtils.handResult())
}