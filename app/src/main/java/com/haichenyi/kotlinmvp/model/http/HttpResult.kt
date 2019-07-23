package com.haichenyi.kotlinmvp.model.http

/**
 * @Author haichenyi
 * @Desc 有data数据返回
 * @Date 2019/7/22-16:53
 * @Home haichenyi.com
 */
class HttpResult<T>(var code: Int = 0, var msg: String = "", var data: T? = null)