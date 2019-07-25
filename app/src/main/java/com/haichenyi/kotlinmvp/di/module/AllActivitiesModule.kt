package com.haichenyi.kotlinmvp.di.module

import com.haichenyi.kotlinmvp.di.component.ActComponent
import com.haichenyi.kotlinmvp.ui.activity.MainActivity
import com.haichenyi.kotlinmvp.ui.activity.TestActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/19-11:05
 * @Home haichenyi.com
 */
@Module(subcomponents = [ActComponent::class])
abstract class AllActivitiesModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivityInjector(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeTestActivityInjector(): TestActivity
}