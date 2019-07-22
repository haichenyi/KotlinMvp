package com.haichenyi.kotlinmvp.presenter

import android.util.Log
import androidx.lifecycle.Observer
import com.haichenyi.kotlinmvp.base.BasePresenter
import com.haichenyi.kotlinmvp.base.BaseView
import com.haichenyi.kotlinmvp.model.Bean
import com.haichenyi.kotlinmvp.model.Bean1
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/19-16:48
 * @Home haichenyi.com
 */
class MainPresenter @Inject internal constructor() :BasePresenter<BaseView>() {

    fun initLiveData(){
        setObserver("asd", Observer<Bean1> {
            Log.v("wz","2222")
        })
    }

    fun loadData(){
        Log.e("wz","1111")
        callBackUi("qwer",Bean())
        callBack("asd",Bean1())
    }
}