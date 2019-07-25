package com.haichenyi.kotlinmvp.model.http

import com.haichenyi.kotlinmvp.model.http.api.HttpCode
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-17:02
 * @Home haichenyi.com
 */
object MyRxUtils {
    /**
     * 从scheduler切换到主线程
     */
    fun <T> toMain(scheduler: Scheduler): FlowableTransformer<T, T> {
        return FlowableTransformer {
            it.subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())
        }
    }

    fun <T> handResult(): FlowableTransformer<HttpResult<T>, T> {
        return FlowableTransformer { it ->
            it.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap {
                    if (it.code == HttpCode.SUCCESS) {
                        return@flatMap create(it.data)
                    } else {
                        return@flatMap Flowable.error<T> { ApiException(it.code, it.msg) }
                    }
                }
        }
    }

    private fun <T> create(data: T): Flowable<T> {
        return Flowable.create({
            it.onNext(data)
            it.onComplete()
        }, BackpressureStrategy.ERROR)
    }
}