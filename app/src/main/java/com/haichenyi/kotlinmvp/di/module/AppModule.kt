package com.haichenyi.kotlinmvp.di.module

import com.haichenyi.kotlinmvp.model.http.api.HttpHelper
import com.haichenyi.kotlinmvp.model.http.api.RetrofitHelper
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
    fun provideHttpHelper(retrofitHelper: RetrofitHelper): HttpHelper = retrofitHelper
}