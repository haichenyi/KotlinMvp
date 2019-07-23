package com.haichenyi.kotlinmvp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.haichenyi.kotlinmvp.R
import com.haichenyi.kotlinmvp.base.BaseActivity
import com.haichenyi.kotlinmvp.third.livedata.bean.Bean
import com.haichenyi.kotlinmvp.presenter.MainPresenter
import com.haichenyi.kotlinmvp.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>() {
    override fun isFullScreen() = false

    override fun isAttachToolbar() = true

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun initLiveData() {
        presenter?.initLiveData()
        presenter?.setObserver("qwer", Observer<Bean> {
            tvContent.text = "我是你爸爸！"
        })
    }

    override fun initView() {
        initToolbar(isShowBack = false, isShowMore = true).setCenter("主页")
            .setStatusColor(R.color.colorAccent).setToolbarColor(R.color.white).setMoreTitle("相机")
    }

    override fun initData() {
        presenter?.loadData()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            flMore -> showToast("相机")
        }
    }
}
