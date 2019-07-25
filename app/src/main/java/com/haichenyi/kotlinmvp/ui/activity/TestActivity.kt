package com.haichenyi.kotlinmvp.ui.activity

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.haichenyi.kotlinmvp.R
import com.haichenyi.kotlinmvp.base.BaseActivity
import com.haichenyi.kotlinmvp.model.bean.IpBean
import com.haichenyi.kotlinmvp.presenter.EmptyPres
import com.haichenyi.kotlinmvp.third.router.RouterKey
import com.haichenyi.kotlinmvp.third.router.RouterPath
import kotlinx.android.synthetic.main.activity_test.*

@Route(path = RouterPath.ACT_TEST)
class TestActivity : BaseActivity<EmptyPres>() {
    @Autowired
    @JvmField
    var name: String? = null

    @Autowired
    @JvmField
    var ipBean: IpBean? = null

    @Autowired
    @JvmField
    var ipBeanList: MutableList<IpBean>? = null

    @Autowired(name = RouterKey.NAME)
    @JvmField
    var n: String? = null

    @Autowired(name = RouterKey.IP_BEAN_LIST)
    @JvmField
    var list: MutableList<IpBean>? = null

    @Autowired(name = RouterKey.IP_BEAN)
    @JvmField
    var bean: IpBean? = null

    override fun initLiveData() {

    }

    override fun initData() {
        tvName1.text = name.plus("-").plus(ipBean?.ip).plus("-").plus(ipBeanList?.size)
        tvName2.text = n.plus("-").plus(bean?.ip).plus("-").plus(list?.size)
    }

    override fun initView() {

    }

    override fun getLayoutRes(): Int = R.layout.activity_test

    override fun isFullScreen(): Boolean = false

    override fun isAttachToolbar(): Boolean = true
}