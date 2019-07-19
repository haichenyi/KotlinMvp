package com.haichenyi.kotlinmvp.presenter

import android.util.Log
import com.haichenyi.kotlinmvp.base.BasePresenter
import com.haichenyi.kotlinmvp.base.BaseView
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/19-16:48
 * @Home haichenyi.com
 */
class MainPresenter @Inject internal constructor() :BasePresenter<BaseView>() {

    fun loadData(){
        Log.e("wz","1111")
    }
}