package com.example.sbotlevskyi.myhelps.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity
class User {
    @PrimaryKey
    private val uid: Int = 0

//    @ColumnInfo(name = "first_name")
//    private val firstName: String? = null
//
//    @ColumnInfo(name = "last_name")
//    private val lastName: String? = null

    // Getters and setters are ignored for brevity,
    // but they're required for Room to work.

    lateinit var login: String
    var id: Long = 0
    lateinit var url: String
    lateinit var html_url: String
    lateinit var followers_url: String
    lateinit var following_url: String
    lateinit var starred_url: String
    lateinit var gists_url: String
    lateinit var type: String
    var score: Int = 0

}

data class Result(val total_count: Int, val incomplete_results: Boolean, val items: List<User>)