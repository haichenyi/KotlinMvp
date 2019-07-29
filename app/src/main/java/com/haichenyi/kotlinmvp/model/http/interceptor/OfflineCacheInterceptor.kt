package com.haichenyi.kotlinmvp.model.http.interceptor

import com.haichenyi.kotlinmvp.utils.NetworkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * @Author haichenyi
 * @Desc 没网的时候缓存拦截器
 * @Date 2019/7/29-15:24
 * @Home haichenyi.com
 */
class OfflineCacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!NetworkUtils.hasNetwork()) {
            request = request.newBuilder()
                .cacheControl(
                    CacheControl.Builder()
                        .maxStale(60, TimeUnit.SECONDS)
                        .onlyIfCached()
                        .build()
                )
                .build()
        }
        return chain.proceed(request)
    }
}