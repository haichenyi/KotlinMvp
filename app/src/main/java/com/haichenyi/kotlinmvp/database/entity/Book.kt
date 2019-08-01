package com.haichenyi.kotlinmvp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/8/1-11:21
 * @Home haichenyi.com
 */
@Entity(tableName = "book")
class Book(
    @PrimaryKey
    @ColumnInfo(name = "ID")
    val id: Long,
    @ColumnInfo(name = "NAME")
    val name: String
)