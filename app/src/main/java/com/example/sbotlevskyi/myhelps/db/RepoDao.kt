package com.example.sbotlevskyi.myhelps.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.sbotlevskyi.myhelps.model.`RepoResponse.kt`
import com.example.sbotlevskyi.myhelps.model.User

@Dao
interface RepoDao {
    @Query("SELECT * FROM ```RepoResponse.kt```")
    fun getAll(): List<`RepoResponse.kt`>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE 'first_name' LIKE :first AND 'last_name' LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): `RepoResponse.kt`

    @Insert
    fun insertAll(vararg repo: `RepoResponse.kt`)

    @Delete
    fun delete(repo: `RepoResponse.kt`)
}