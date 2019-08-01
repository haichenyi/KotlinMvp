package com.haichenyi.kotlinmvp.presenter

import androidx.lifecycle.Observer
import com.haichenyi.kotlinmvp.base.BasePresenter
import com.haichenyi.kotlinmvp.base.BaseView
import com.haichenyi.kotlinmvp.base.MyApp
import com.haichenyi.kotlinmvp.model.bean.IpBean
import com.haichenyi.kotlinmvp.model.http.HttpObserver
import com.haichenyi.kotlinmvp.third.livedata.LiveDataKey
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
        callBack("asd", Bean1())
        MyApp.spHelper.putValue("qwe", "asd")
        request(MyApp.httpHelper.getIp("myip"), object : HttpObserver<IpBean>(baseView = baseView) {
            override fun onSuccess(t: IpBean) {
                callBackUi(LiveDataKey.IP_KEY, t)
            }

            override fun onFailed(t: Throwable) {
                super.onFailed(t)
                LogUtil.v(LogUtil.LOG_WZ, t.message!!)
            }

        })
    }
}