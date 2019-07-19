package com.haichenyi.kotlinmvp.di.component

import com.haichenyi.kotlinmvp.base.BaseActivity
import com.haichenyi.kotlinmvp.base.BasePresenter
import com.haichenyi.kotlinmvp.base.BaseView
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/19-11:02
 * @Home haichenyi.com
 */
@Subcomponent(modules = [AndroidSupportInjectionModule::class])
interface ActComponent : AndroidInjector<BaseActivity<BasePresenter<BaseView>>> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BaseActivity<BasePresenter<BaseView>>>()
}