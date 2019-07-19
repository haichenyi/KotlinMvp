package com.haichenyi.kotlinmvp.base

import android.app.Activity
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.haichenyi.kotlinmvp.R
import com.haichenyi.kotlinmvp.utils.getColorRes
import com.haichenyi.kotlinmvp.utils.getDrawableRes
import com.haichenyi.kotlinmvp.utils.inflate

/**
 * @Author haichenyi
 * @Desc 基类
 * @Date 2019/7/15-10:14
 * @Home haichenyi.com
 */
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener, BaseView {
    private lateinit var toolbar: Toolbar
    protected lateinit var flBack: FrameLayout
    private lateinit var tvBack: TextView
    private lateinit var tvCenter: TextView
    protected lateinit var flMore: FrameLayout
    private lateinit var tvMore: TextView
    private var loadingDialog: AlertDialog? = null

    companion object {
        //用于存放当前activity的引用
        val activities = ArrayList<Activity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activities.add(this)
        if (isFullScreen()) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        //设置竖屏
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        val rootView = inflate(R.layout.activity_base, null)
        val layoutId = getLayoutRes()
        initToolbarView(rootView)
        if (layoutId == 0) {
            setContentView(rootView)
        } else {
            if (isAttachToolbar()) {
                setContentView(inflate(layoutId, rootView as ViewGroup, true))
            } else {
                setContentView(layoutId)
            }

        }
        initView()
        initData()
        setOnClick(flBack, flMore)
    }

    open fun initData() {

    }

    open fun initView() {

    }

    /**
     * 初始化toolbar布局的控件
     */
    private fun initToolbarView(rootView: View) {
        toolbar = rootView.findViewById(R.id.toolbar)
        flBack = toolbar.findViewById(R.id.flBack)
        tvBack = toolbar.findViewById(R.id.tvBack)
        tvCenter = toolbar.findViewById(R.id.tvCenter)
        flMore = toolbar.findViewById(R.id.flMore)
        tvMore = toolbar.findViewById(R.id.tvMore)
    }

    override fun onDestroy() {
        super.onDestroy()
        activities.remove(this)
    }

    /**
     * 设置布局
     */
    abstract fun getLayoutRes(): Int

    /**
     * 设置是否全屏
     */
    abstract fun isFullScreen(): Boolean

    /**
     * 设置是否需要toolbar
     */
    abstract fun isAttachToolbar(): Boolean

    /**
     * 设置标题
     */
    fun setCenter(title: String): BaseActivity {
        tvCenter.text = title
        return this
    }

    /**
     * 初始化标题栏
     */
    fun initToolbar(isShowBack: Boolean, isShowMore: Boolean): BaseActivity {
        setSupportActionBar(toolbar)
        if (isAttachToolbar()) {
            supportActionBar?.show()
            flBack.visibility = if (isShowBack) View.VISIBLE else View.INVISIBLE
            flMore.visibility = if (isShowMore) View.VISIBLE else View.INVISIBLE
        } else {
            supportActionBar?.hide()
        }

        return this
    }

    /**
     * 设置状态栏颜色
     */
    fun setStatusColor(color: Int): BaseActivity {
        window.statusBarColor = getColorRes(color)
        return this
    }

    /**
     * 设置toolbar右边的标题
     */
    fun setMoreTitle(text: String): BaseActivity {
        tvMore.background = null
        tvMore.text = text
        return this
    }

    /**
     * 设置toolbar右边的图片
     */
    fun setMoreBack(@DrawableRes drawableId: Int): BaseActivity {
        tvMore.text = ""
        tvMore.background = getDrawableRes(drawableId)
        return this
    }

    /**
     * 设置标题栏背景颜色
     */
    fun setToolbarColor(color: Int): BaseActivity {
        toolbar.setBackgroundColor(getColorRes(color))
        return this
    }

    open fun setOnClick(vararg views: View) {
        views.forEach { it.setOnClickListener(this@BaseActivity) }
    }


    override fun onClick(v: View?) {
        when (v) {
            flBack -> finish()
        }
    }

    override fun showLoading() {
        if (null == loadingDialog) {
            loadingDialog = AlertDialog.Builder(this).setView(ProgressBar(this)).create()
            loadingDialog?.let {
                it.setCanceledOnTouchOutside(false)
                it.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
        }
        loadingDialog?.let {
            if (!it.isShowing) {
                it.show()
            }
        }
    }

    override fun hideLoading() {
        loadingDialog?.let {
            if (it.isShowing) {
                it.dismiss()
            }
        }
        loadingDialog = null
    }

}