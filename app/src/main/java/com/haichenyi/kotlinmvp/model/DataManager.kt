package com.haichenyi.kotlinmvp.model

import com.haichenyi.kotlinmvp.model.bean.CodeBean
import com.haichenyi.kotlinmvp.model.http.api.HttpHelper
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:20
 * @Home haichenyi.com
 */
class DataManager @Inject constructor(val httpHelper: HttpHelper) : HttpHelper {
    override fun getRegisterCode(accountName: String): Flowable<CodeBean> = httpHelper.getRegisterCode(accountName)

}