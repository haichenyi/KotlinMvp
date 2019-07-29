package com.haichenyi.kotlinmvp.model.http.api

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:18
 * @Home haichenyi.com
 */
object HttpProtocol {
    //http://127.0.0.1:8080/examples/info.json
    const val HTTP_HOST = "http://172.30.88.1"
    private const val HTTP_PORT = ":8080"
    private const val HTTP_APP_TYPE = "/examples"
    /**
     * 获取注册验证码
     */
    const val HTTP_GET_IP = "$HTTP_HOST$HTTP_PORT$HTTP_APP_TYPE/info.json"
}