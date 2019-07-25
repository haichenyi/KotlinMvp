package com.haichenyi.kotlinmvp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.text.TextUtils
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.haichenyi.kotlinmvp.Interface.PermissionDismissListener
import com.haichenyi.kotlinmvp.base.BaseActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.util.*

/**
 * @Author haichenyi
 * @Desc 权限管理
 * @Date 2019/7/24-10:04
 * @Home haichenyi.com
 */
object PermissionUtils {
    /**
     * 请求权限的封装.
     *
     * @param activity    activity
     * @param listener    listener
     * @param permission 需要请求的权限名称
     */
    @SuppressLint("CheckResult")
    fun requestPermission(
        activity: BaseActivity<*>,
        vararg permission: String,
        wz: (hasPermission: Boolean) -> Unit
    ) {
        RxPermissions(activity).request(*permission).subscribe { wz(it) }
    }

    /**
     * 用户拒绝给权限之后，调用该方法提示用户去设置页面给权限
     *
     * @param activity       activity
     * @param permissionName 权限名称
     * @param msg            给这个权限的理由
     * @param listener       dialog消失的回调方法
     */
    fun setPermission(
        activity: BaseActivity<*>,
        permissionName: String,
        msg: String,
        listener: PermissionDismissListener?
    ) {
        AlertDialog.Builder(activity).apply {
            setTitle("权限申请")
            setMessage(String.format(Locale.getDefault(), "请在“权限”中开启“%1s权限”，以正常使用%2s", permissionName, msg))
            setCancelable(false)
            setNegativeButton(android.R.string.cancel) { _, _ -> listener?.onCancel() }
            setPositiveButton("去设置") { _, _ ->
                run {
                    setPermissionsSetting(activity)
                    listener?.onSetting()
                }
            }
        }.create().show()
    }

    /**
     * 跳转小米系统的设置页面.
     *
     * @param activity activity
     */
    private fun setPermissionsSetting(activity: BaseActivity<*>) {
        if (isMiUi()) {
            try {
                // MIUI 8
                activity.startActivityForResult(
                    Intent("miui.intent.action.APP_PERM_EDITOR")
                        .setClassName(
                            "com.miui.securitycenter",
                            "com.miui.permcenter.permissions.PermissionsEditorActivity"
                        )
                        .putExtra("extra_pkgname", activity.packageName), 1000
                )
            } catch (e: Exception) {
                try {
                    // MIUI 5/6/7
                    activity.startActivityForResult(
                        Intent("miui.intent.action.APP_PERM_EDITOR")
                            .setClassName(
                                "com.miui.securitycenter",
                                "com.miui.permcenter.permissions.AppPermissionsEditorActivity"
                            )
                            .putExtra("extra_pkgname", activity.packageName), 1000
                    )
                } catch (e1: Exception) {
                    // 否则跳转到应用详情
                    activity.startActivityForResult(
                        Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            .setData(Uri.fromParts("package", activity.packageName, null)), 1000
                    )
                }

            }

        } else {
            activity.startActivityForResult(
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    .setData(Uri.fromParts("package", activity.packageName, null)), 1000
            )
        }
    }

    /**
     * 判断是否是MiUi系统.
     *
     * @return boolean
     */
    private fun isMiUi(): Boolean {
        val device = Build.MANUFACTURER
        if (TextUtils.equals(device, "Xiaomi")) {
            val prop = Properties()
            try {
                prop.load(
                    FileInputStream(
                        File(
                            Environment.getRootDirectory(),
                            "build.prop"
                        )
                    )
                )
                return (prop.getProperty("ro.miui.ui.version.code", null) != null
                        || prop.getProperty("ro.miui.ui.version.name", null) != null
                        || prop.getProperty("ro.miui.internal.storage", null) != null)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return false
    }

    /**
     * 检测权限是否获得
     *
     * @param context     context
     * @param permissions permissions
     * @return true：已获取，false：未获取
     */
    fun checkPermission(context: Context, vararg permissions: String): Boolean {
        for (permission in permissions) {
            val per = ContextCompat.checkSelfPermission(context, permission)
            if (PackageManager.PERMISSION_GRANTED != per) {
                return false
            }
        }
        return true
    }

    /**
     * 设置WRITE_SETTINGS权限
     *
     * @param activity activity
     */
    fun setWriteSettings(activity: BaseActivity<*>, listener: PermissionDismissListener?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.System.canWrite(activity)) {
            AlertDialog.Builder(activity).apply {
                setTitle("权限申请")
                setMessage(String.format(Locale.getDefault(), "请在“权限”中开启“%1s权限”，以正常使用%2s", "系统", "部分功能"))
                setCancelable(false)
                setNegativeButton(android.R.string.cancel) { _, _ -> listener?.onCancel() }
                setPositiveButton("去设置") { _, _ ->
                    run {
                        listener?.onSetting()
                        val intent =
                            Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + activity.packageName))
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        activity.startActivity(intent)
                    }
                }
            }.create().show()
        }
    }
}