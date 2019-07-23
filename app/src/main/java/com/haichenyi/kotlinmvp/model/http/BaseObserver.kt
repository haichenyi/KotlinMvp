package com.haichenyi.kotlinmvp.model.http

import io.reactivex.FlowableSubscriber
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscription

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:23
 * @Home haichenyi.com
 */
open class BaseObserver<T> : FlowableSubscriber<T>, SingleObserver<T> {
    override fun onSubscribe(d: Disposable) {

    }

    override fun onSuccess(t: T) {

    }

    override fun onComplete() {

    }

    override fun onSubscribe(s: Subscription) {
        s.request(Integer.MAX_VALUE.toLong())
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(t: Throwable) {

    }

}