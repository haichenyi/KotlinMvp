package com.haichenyi.kotlinmvp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.haichenyi.kotlinmvp.database.dao.BookDao
import com.haichenyi.kotlinmvp.database.dao.UserDao
import com.haichenyi.kotlinmvp.database.entity.Book
import com.haichenyi.kotlinmvp.database.entity.User

/**
 * @Author haichenyi
 * @Desc
 * @Date 2019/8/1-11:19
 * @Home haichenyi.com
 */
@Database(entities = [User::class, Book::class], version = 1, exportSchema = true)
abstract class MyDatabases : RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun bookDao(): BookDao


    companion object {
        private var INSTANCE: MyDatabases? = null

        fun getInstance(context: Context): MyDatabases = INSTANCE ?: synchronized(this) {
            INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context): MyDatabases =
            Room.databaseBuilder(context.applicationContext, MyDatabases::class.java, "haichenyi.db").build()
    }
}