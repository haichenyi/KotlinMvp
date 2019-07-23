package com.haichenyi.kotlinmvp.model.http

import java.lang.Exception

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:11
 * @Home haichenyi.com
 */
class ApiException(code: Int, msg: String) : Exception(msg)