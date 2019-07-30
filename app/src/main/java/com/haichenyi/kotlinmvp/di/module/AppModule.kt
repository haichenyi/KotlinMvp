package com.haichenyi.kotlinmvp.di.module

import com.haichenyi.kotlinmvp.model.http.api.HttpHelper
import com.haichenyi.kotlinmvp.model.http.api.HttpReal
import com.haichenyi.kotlinmvp.model.sharepreference.SpHelper
import com.haichenyi.kotlinmvp.model.sharepreference.SpReal
import com.haichenyi.kotlinmvp.third.router.RouterHelper
import com.haichenyi.kotlinmvp.third.router.RouterReal
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/19-11:00
 * @Home haichenyi.com
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideHttpHelper(httpReal: HttpReal): HttpHelper = httpReal

    @Provides
    @Singleton
    fun provideSpHelper(spReal: SpReal): SpHelper = spReal

    @Provides
    @Singleton
    fun provideRouterHelper(routerReal: RouterReal): RouterHelper = routerReal
}