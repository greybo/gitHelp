package com.example.sbotlevskyi.myhelps.db

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import com.example.sbotlevskyi.myhelps.model.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}