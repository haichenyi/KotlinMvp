package com.haichenyi.kotlinmvp.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.OnLifecycleEvent
import com.haichenyi.kotlinmvp.third.livedata.BaseLiveData
import com.haichenyi.kotlinmvp.third.livedata.LiveDataManager

/**
 * @Author haichenyi
 * @Desc P层基类
 * @Date 2019/7/19-13:47
 * @Home haichenyi.com
 */
open class BasePresenter<V : BaseView> : LifecycleObserver {
    protected var baseView: V? = null

    /**
     * 设置LiveData的Observer
     *
     * @param object   当前对象
     * @param key      键
     * @param observer 监听器
     * @param <T>      数据类型
     */
    @Synchronized
    fun <T> setObserver(any: Any, key: String, observer: Observer<T>) {
        if (null == LiveDataManager<T>().instance.getLiveData(any.toString().plus(key))) {
            val liveData = BaseLiveData<T>()
            liveData.observe(baseView!!, observer)
            LiveDataManager<T>().instance.putLiveData(any, key, liveData)
        }
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
        baseView = null
    }
}