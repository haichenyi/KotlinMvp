package com.haichenyi.kotlinmvp.model.http.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author haichenyi
 * @Desc 有网的时候缓存拦截器
 * @Date 2019/7/29-15:23
 * @Home haichenyi.com
 */
class NetworkCacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        //在线的时候的缓存过期时间，如果想要不缓存，直接时间设置为0
        val onlineCacheTime = 30
        return response.newBuilder()
            .header("Cache-Control", "public, max-age=$onlineCacheTime")
            .removeHeader("Pragma")
            .build()
    }
}