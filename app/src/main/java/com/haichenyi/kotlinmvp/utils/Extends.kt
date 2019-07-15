package com.haichenyi.kotlinmvp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat

/**
 * @Author haichenyi
 * @Desc 扩展方法
 * @Date 2019/7/15-15:13
 * @Home haichenyi.com
 */

fun Context.inflate(@LayoutRes layout: Int, @Nullable root: ViewGroup?) =
    LayoutInflater.from(this).inflate(layout, root)!!

fun Context.inflate(@LayoutRes layout: Int, @Nullable root: ViewGroup?, attachToRoot: Boolean) =
    LayoutInflater.from(this).inflate(layout, root, attachToRoot)!!

@SuppressLint("ResourceType")
fun Context.getColorRes(@ColorInt color: Int) = ContextCompat.getColor(this, color)

fun Context.getDrawableRes(drawableId: Int) = ContextCompat.getDrawable(this, drawableId)

fun showToast(text: String) = ToastUtils.show(text)





