package com.haichenyi.kotlinmvp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.haichenyi.kotlinmvp.database.entity.Book

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/8/1-13:48
 * @Home haichenyi.com
 */
@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(book: Book)
}