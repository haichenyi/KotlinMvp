package com.haichenyi.kotlinmvp.model.http.api

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:18
 * @Home haichenyi.com
 */
object HttpProtocol {
    //    String HTTP_HOST = "http://101.132.170.122";
    const val HTTP_HOST = "http://www.yunjikj.info"
    private const val HTTP_PORT = ":8080/"
    private const val HTTP_APP_TYPE = "qd/"
    private const val HTTP_VERSION = "v1.0.0/"
    /**
     * 获取注册验证码
     */
    const val HTTP_REGISTER_GET_CODE = HTTP_HOST + HTTP_PORT + HTTP_APP_TYPE + HTTP_VERSION + "register/getCode"
}