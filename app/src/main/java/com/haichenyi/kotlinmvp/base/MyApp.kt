package com.haichenyi.kotlinmvp.base

import com.haichenyi.kotlinmvp.di.component.DaggerAppComponent
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

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =DaggerAppComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
        ToastUtils.init(this)
    }

}