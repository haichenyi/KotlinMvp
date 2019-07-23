package com.haichenyi.kotlinmvp.model.http

import com.haichenyi.kotlinmvp.base.BaseView

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:47
 * @Home haichenyi.com
 */
abstract class HttpObserver<T>(private var baseView: BaseView?) : BaseObserver<T>() {

    init {
        baseView?.showLoading()
    }

    override fun onError(t: Throwable) {
        super.onError(t)
        baseView?.hideLoading()
        onFailed(t)
    }

    open fun onFailed(t: Throwable) {

    }

    abstract override fun onSuccess(t: T)

    override fun onComplete() {
        super.onComplete()
        baseView?.hideLoading()
    }

}