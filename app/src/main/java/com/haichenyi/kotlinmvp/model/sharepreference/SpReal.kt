package com.haichenyi.kotlinmvp.model.sharepreference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.haichenyi.kotlinmvp.base.MyApp
import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/23-14:28
 * @Home haichenyi.com
 */
class SpReal @SuppressLint("CommitPrefEdits") @Inject constructor() : SpHelper {
    private var mSp: SharedPreferences
    private var mEditor: SharedPreferences.Editor

    init {
        mSp = MyApp.instance.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        mEditor = mSp.edit()
    }

    companion object {
        const val SP_NAME = "sp_name"
    }

    override fun putValue(key: String, any: Any) {
        when (any) {
            is String -> mEditor.putString(key, any)
            is Int -> mEditor.putInt(key, any)
            is Boolean -> mEditor.putBoolean(key, any)
            is Float -> mEditor.putFloat(key, any)
            is Long -> mEditor.putLong(key, any)
            else -> mEditor.putString(key, any.toString())
        }
        SharedPreferencesCompat.apply(mEditor)
    }

    override fun putMap(key: String, map: Map<*, *>) {
        mEditor.putString(key, Gson().toJson(map))
        SharedPreferencesCompat.apply(mEditor)
    }

    override fun getMap(key: String): Map<*, *>? {
        return try {
            Gson().fromJson(getValue(key, "") as String, Map::class.java)
        } catch (e: Exception) {
            null
        }

    }

    override fun getValue(key: String, any: Any): Any? {
        return when (any) {
            is String -> mSp.getString(key, any)
            is Int -> mSp.getInt(key, any)
            is Boolean -> mSp.getBoolean(key, any)
            is Float -> mSp.getFloat(key, any)
            is Long -> mSp.getLong(key, any)
            else -> null
        }
    }

    @SuppressLint("CommitPrefEdits")
    override fun putValue(sp: SharedPreferences, key: String, any: Any) {
        val editor = sp.edit()
        when (any) {
            is String -> editor.putString(key, any)
            is Int -> editor.putInt(key, any)
            is Boolean -> editor.putBoolean(key, any)
            is Float -> editor.putFloat(key, any)
            is Long -> editor.putLong(key, any)
            else -> editor.putString(key, any.toString())
        }
        SharedPreferencesCompat.apply(editor)
    }

    override fun getValue(sp: SharedPreferences, key: String, any: Any): Any? {
        return when (any) {
            is String -> sp.getString(key, any)
            is Int -> sp.getInt(key, any)
            is Boolean -> sp.getBoolean(key, any)
            is Float -> sp.getFloat(key, any)
            is Long -> sp.getLong(key, any)
            else -> null
        }
    }


}