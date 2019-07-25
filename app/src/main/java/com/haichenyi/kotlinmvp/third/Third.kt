package com.haichenyi.kotlinmvp.third

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.haichenyi.kotlinmvp.BuildConfig

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/15-10:50
 * @Home haichenyi.com
 */
object Third {
    /**
     * 初始化ARouter
     */
    fun initARouter(app: Application) {
        if (BuildConfig.DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()// 打印日志
            ARouter.openDebug()// 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(app)
    }
}