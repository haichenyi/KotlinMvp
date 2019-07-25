package com.haichenyi.kotlinmvp.third.router

import com.alibaba.android.arouter.launcher.ARouter
import com.haichenyi.kotlinmvp.model.bean.IpBean
import javax.inject.Inject

class RouterReal @Inject constructor() : RouterHelper {
    override fun jumpTestActivity() {
        val ipBean = IpBean().apply {
            country = "中国"
            city = "上海"
            isp = "电信"
            ip = "192.168.0.1"
        }

        val ipBeanList = mutableListOf<IpBean>()
        ipBeanList.add(ipBean)
        ipBeanList.add(ipBean)
        ipBeanList.add(ipBean)
        ARouter.getInstance().apply {
            build(RouterPath.ACT_TEST).apply {
                withObject(RouterKey.IP_BEAN, ipBean)
                withObject(RouterKey.IP_BEAN_LIST, ipBeanList)
                withString(RouterKey.NAME, "中国")
                navigation()
            }
        }

    }
}