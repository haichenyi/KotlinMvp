package com.haichenyi.kotlinmvp.di.component

import com.haichenyi.kotlinmvp.base.MyApp
import com.haichenyi.kotlinmvp.di.module.AllActivitiesModule
import com.haichenyi.kotlinmvp.di.module.AppModule
import com.haichenyi.kotlinmvp.di.module.HttpModule
import com.haichenyi.kotlinmvp.model.http.api.HttpHelper
import com.haichenyi.kotlinmvp.model.sharepreference.SpHelper
import com.haichenyi.kotlinmvp.third.router.RouterHelper
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject

import javax.inject.Singleton

/**
 * @Title: AppComponent
 * @Des:
 * @Author: haichenyi
 * @Date: 2018/11/21 0021
 * @Email: haichenyi@yeah.net
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, HttpModule::class, AppModule::class, AllActivitiesModule::class])
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApp>()

    fun getHttpHelper(): HttpHelper

    fun getSpHelper(): SpHelper

    fun getRouterHelper(): RouterHelper
}
