package com.haichenyi.kotlinmvp.di.component

import com.haichenyi.kotlinmvp.base.MyApp
import com.haichenyi.kotlinmvp.di.module.AllActivitiesModule
import com.haichenyi.kotlinmvp.di.module.AppModule
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
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, AllActivitiesModule::class])
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApp>()
}
