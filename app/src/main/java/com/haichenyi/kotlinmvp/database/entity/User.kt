package com.haichenyi.kotlinmvp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/8/1-10:54
 * @Home haichenyi.com
 */
@Entity(tableName = "usersInfo")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "USER_ID")
    val userId: Long,
    @ColumnInfo(name = "USERNAME")
    val name: String
)

