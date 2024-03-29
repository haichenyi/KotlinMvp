package com.haichenyi.kotlinmvp.base

import androidx.room.Room
import com.alibaba.android.arouter.launcher.ARouter
import com.haichenyi.kotlinmvp.database.MyDatabases
import com.haichenyi.kotlinmvp.di.component.DaggerAppComponent
import com.haichenyi.kotlinmvp.model.http.api.HttpHelper
import com.haichenyi.kotlinmvp.model.sharepreference.SpHelper
import com.haichenyi.kotlinmvp.third.Third
import com.haichenyi.kotlinmvp.third.router.RouterHelper
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
        lateinit var httpHelper: HttpHelper
        lateinit var spHelper: SpHelper
        lateinit var routerHelper: RouterHelper
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder().create(this)

    override fun onCreate() {
        super.onCreate()
        Third.initARouter(this)
        ToastUtils.init(this)
        instance = this
        //初始化全局变量
        initOwn()
    }

    private fun initOwn() {
        val appComponent = DaggerAppComponent.builder().create(this) as DaggerAppComponent
        httpHelper = appComponent.getHttpHelper()
        spHelper = appComponent.getSpHelper()
        routerHelper = appComponent.getRouterHelper()
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}