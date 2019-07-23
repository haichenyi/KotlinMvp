package com.haichenyi.kotlinmvp.presenter

import androidx.lifecycle.Observer
import com.haichenyi.kotlinmvp.base.BasePresenter
import com.haichenyi.kotlinmvp.base.BaseView
import com.haichenyi.kotlinmvp.model.bean.CodeBean
import com.haichenyi.kotlinmvp.model.http.HttpObserver
import com.haichenyi.kotlinmvp.third.livedata.bean.Bean
import com.haichenyi.kotlinmvp.third.livedata.bean.Bean1
import com.haichenyi.kotlinmvp.utils.LogUtil
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/19-16:48
 * @Home haichenyi.com
 */
class MainPresenter @Inject internal constructor() : BasePresenter<BaseView>() {

    fun initLiveData() {
        setObserver("asd", Observer<Bean1> {
            LogUtil.v(LogUtil.LOG_WZ, "2222")
        })
    }

    fun loadData() {
        LogUtil.v(LogUtil.LOG_WZ, "1111")
        callBackUi("qwer", Bean())
        callBack("asd", Bean1())
        spIml!!.putValue("qwe","asd")
        request(httpIml!!.getRegisterCode("12345678912"), object : HttpObserver<CodeBean>(baseView = baseView) {
            override fun onSuccess(t: CodeBean) {
                LogUtil.v(LogUtil.LOG_WZ, "success")
            }

            override fun onFailed(t: Throwable) {
                super.onFailed(t)
                LogUtil.v(LogUtil.LOG_WZ, t.message!!)
            }

        })
    }
}