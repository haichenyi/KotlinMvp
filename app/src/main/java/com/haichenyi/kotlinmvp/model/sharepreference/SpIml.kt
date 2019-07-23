package com.haichenyi.kotlinmvp.model.sharepreference

import javax.inject.Inject

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/7/23-14:06
 * @Home haichenyi.com
 */
class SpIml @Inject constructor(private val spReal: SpReal) : SpHelper by spReal