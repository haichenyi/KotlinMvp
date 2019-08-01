package com.haichenyi.kotlinmvp.database.dao

import androidx.room.*
import com.haichenyi.kotlinmvp.database.entity.User

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/8/1-11:00
 * @Home haichenyi.com
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query(value = "SELECT * FROM usersInfo")
    fun queryAll(): MutableList<User>
}