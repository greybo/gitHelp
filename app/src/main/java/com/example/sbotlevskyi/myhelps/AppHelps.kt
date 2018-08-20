package com.example.sbotlevskyi.myhelps

import android.app.Application
import android.arch.persistence.room.Room
import com.example.sbotlevskyi.myhelps.db.AppDatabase

class AppHelps : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    fun getDb(): AppDatabase {
        return Room.databaseBuilder(applicationContext,
                AppDatabase::class.java, "database-name").build()
    }

}