package com.haichenyi.kotlinmvp.di.module

import com.haichenyi.kotlinmvp.base.MyApp
import com.haichenyi.kotlinmvp.di.qualifier.ApiUrl
import com.haichenyi.kotlinmvp.model.http.api.HttpApi
import com.haichenyi.kotlinmvp.model.http.api.HttpProtocol
import com.haichenyi.kotlinmvp.utils.LogUtil
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-18:00
 * @Home haichenyi.com
 */
@Module
class HttpModule {

    @Provides
    @Singleton
    fun providerOkHttpBuilder(): OkHttpClient.Builder {
        /*.cookieJar(object : CookieJar {
                override fun loadForRequest(url: HttpUrl): List<Cookie> {

                }

                override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {

                }

            })*/
        return OkHttpClient.Builder().apply {
            connectTimeout(10, TimeUnit.SECONDS)
            val maxCacheSize: Long = 100 * 1024 * 1024
            cache(Cache(File(MyApp.instance.cacheDir.absolutePath), maxCacheSize))
            readTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
        }
    }

    @Provides
    @Singleton
    fun providerClient(builder: OkHttpClient.Builder): OkHttpClient {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                LogUtil.v(LogUtil.LOG_WZ, message)
            }
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return builder.run {
            addInterceptor(interceptor)
//            addInterceptor(OfflineCacheInterceptor())
//            addNetworkInterceptor(NetworkCacheInterceptor())
//            addNetworkInterceptor(CacheInterceptor())
            build()
        }
    }

    @Provides
    @Singleton
    fun providerRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    @Provides
    @Singleton
    fun providerApi(@ApiUrl retrofit: Retrofit): HttpApi {
        return retrofit.create(HttpApi::class.java)
    }

    @Provides
    @Singleton
    @ApiUrl
    fun providerApiRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit {
        return createRetrofit(builder, client, HttpProtocol.HTTP_HOST)
    }


    private fun createRetrofit(builder: Retrofit.Builder, client: OkHttpClient, host: String): Retrofit {
        return builder.run {
            client(client)
            baseUrl(host)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            build()
        }
    }
}