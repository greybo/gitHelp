package com.example.sbotlevskyi.myhelps.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sbotlevskyi.myhelps.R
import com.example.sbotlevskyi.myhelps.rest.KeyValue
import com.example.sbotlevskyi.myhelps.rest.QueryGitHub

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queryGitHub = QueryGitHub()
        queryGitHub.searchUsers(KeyValue.location, KeyValue.language)
    }
}
