package com.haichenyi.kotlinmvp.model.http.api

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/22-16:18
 * @Home haichenyi.com
 */
object HttpProtocol {
    const val HTTP_HOST = "http://ip.taobao.com"
    private const val HTTP_APP_TYPE = "/service"
    /**
     * 获取注册验证码
     */
    const val HTTP_GET_IP = "$HTTP_HOST$HTTP_APP_TYPE/getIpInfo.php"
}