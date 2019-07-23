package com.haichenyi.kotlinmvp.model.http.api

import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:20
 * @Home haichenyi.com
 */
class HttpIml @Inject constructor(private val httpReal: HttpReal) : HttpHelper by httpReal