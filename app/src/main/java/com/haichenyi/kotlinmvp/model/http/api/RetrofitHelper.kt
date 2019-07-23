package com.haichenyi.kotlinmvp.model.http.api

import com.haichenyi.kotlinmvp.model.bean.CodeBean
import com.haichenyi.kotlinmvp.model.http.MyRxUtils
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:19
 * @Home haichenyi.com
 */
class RetrofitHelper @Inject constructor(private var httpApi: HttpApi) : HttpHelper {

    override fun getRegisterCode(accountName: String): Flowable<CodeBean> =
        httpApi.getRegisterCode(accountName).compose(MyRxUtils.handResult())

}