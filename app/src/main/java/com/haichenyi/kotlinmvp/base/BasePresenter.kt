package com.haichenyi.kotlinmvp.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import com.haichenyi.kotlinmvp.model.http.api.HttpIml
import com.haichenyi.kotlinmvp.model.http.HttpObserver
import com.haichenyi.kotlinmvp.model.sharepreference.SpIml
import com.haichenyi.kotlinmvp.third.livedata.BaseLiveData
import com.haichenyi.kotlinmvp.third.livedata.LiveDataManager
import com.haichenyi.kotlinmvp.third.router.RouterIml
import com.uber.autodispose.AutoDispose
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc P层基类
 * @Date 2019/7/19-13:47
 * @Home haichenyi.com
 */
open class BasePresenter<V : BaseView> : LifecycleObserver {

    protected var baseView: V? = null

    fun attachView(view: V) {
        this.baseView = view
    }

    fun <T> request(flow: Flowable<T>, observer: HttpObserver<T>) {
        flow.`as`(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(baseView)))
            .subscribe(observer)
    }

    /**
     * 设置LiveData的Observer
     *
     * @param key      键
     * @param observer 监听器
     * @param <T>      数据类型
     */
    @Synchronized
    fun <T> setObserver(key: String, observer: Observer<T>) {
        if (LiveDataManager.contain(this.toString().plus(key))) {
            val liveData = BaseLiveData<T>()
            liveData.observe(baseView!!, observer)
            LiveDataManager.putLiveData(this, key, liveData)
        }
    }

    fun <T> callBackUi(key: String, t: T) {
        LiveDataManager.getLiveData<T>(this.toString().plus(key))?.callBackUi(t)
    }

    fun <T> callBack(key: String, t: T) {
        LiveDataManager.getLiveData<T>(this.toString().plus(key))?.callBack(t)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        LiveDataManager.clean(this)
        baseView = null
    }
}