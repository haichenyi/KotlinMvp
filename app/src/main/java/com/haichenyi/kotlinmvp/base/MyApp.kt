package com.haichenyi.kotlinmvp.base

import com.alibaba.android.arouter.launcher.ARouter
import com.haichenyi.kotlinmvp.di.component.DaggerAppComponent
import com.haichenyi.kotlinmvp.third.Third
import com.haichenyi.kotlinmvp.utils.ToastUtils
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


/**
 * @Author haichenyi
 * @Desc application
 * @Date 2019/7/15-10:17
 * @Home haichenyi.com
 */
class MyApp : DaggerApplication() {
    companion object {
        lateinit var instance: MyApp
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
        Third.initARouter(this)
        ToastUtils.init(this)
        instance = this
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}