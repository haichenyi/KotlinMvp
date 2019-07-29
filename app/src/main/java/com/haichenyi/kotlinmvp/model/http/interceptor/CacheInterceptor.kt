package com.haichenyi.kotlinmvp.model.http.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author haichenyi
 * @Desc 不管有没有网，都是先走缓存，再走服务器
 * @Date 2019/7/29-17:44
 * @Home haichenyi.com
 */
class CacheInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        //在线的时候的缓存过期时间，如果想要不缓存，直接时间设置为0
        val onlineCacheTime = 60
        return response.newBuilder()
            .removeHeader("Pragma")
            .removeHeader("Cache-Control")
            .header("Cache-Control", "public, max-age=$onlineCacheTime")
            .build()
    }
}