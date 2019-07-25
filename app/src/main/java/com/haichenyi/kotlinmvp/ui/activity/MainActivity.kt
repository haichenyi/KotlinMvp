package com.haichenyi.kotlinmvp.ui.activity

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.haichenyi.kotlinmvp.R
import com.haichenyi.kotlinmvp.base.BaseActivity
import com.haichenyi.kotlinmvp.model.bean.IpBean
import com.haichenyi.kotlinmvp.third.livedata.bean.Bean
import com.haichenyi.kotlinmvp.presenter.MainPresenter
import com.haichenyi.kotlinmvp.third.livedata.LiveDataKey
import com.haichenyi.kotlinmvp.utils.PermissionUtils
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
        presenter?.setObserver(LiveDataKey.IP_KEY, Observer<IpBean> {
            tvContent.text = it.country.plus("_").plus(it.city).plus("_").plus(it.isp).plus(":").plus(it.ip)
        })
    }

    override fun initView() {
        initToolbar(isShowBack = false, isShowMore = true).setCenter("主页")
            .setStatusColor(R.color.colorAccent).setToolbarColor(R.color.white).setMoreTitle("相机")
        PermissionUtils.requestPermission(
            activity = this,
            permission = *arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
            wz = {
                if (it) {
                    showToast("获取权限")
                } else {
                    showToast("未获取权限")
                }
            })
    }

    override fun initData() {
        presenter?.loadData()
    }

    override fun onClick(v: View?) {
        super.onClick(v)
        when (v) {
            flMore -> {
                showToast("相机")
                presenter?.routerIml?.jumpTestActivity()
            }
        }
    }
}
