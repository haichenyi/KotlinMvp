package com.haichenyi.kotlinmvp.ui.activity

import android.os.Bundle
import android.view.View
import com.haichenyi.kotlinmvp.R
import com.haichenyi.kotlinmvp.base.BaseActivity
import com.haichenyi.kotlinmvp.utils.showToast

class MainActivity : BaseActivity() {

    override fun getLayoutRes(): Int {

        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar(isToolbar = true, isBack = false, isMore = true).setCenter("主页")
            .setStatusColor(R.color.colorAccent).setToolbarColor(R.color.white).setMoreTitle("相机")
    }

    override fun initView() {
        super.initView()
    }

    override fun initData() {
        super.initData()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            flMore -> showToast("相机")
        }
    }
}
