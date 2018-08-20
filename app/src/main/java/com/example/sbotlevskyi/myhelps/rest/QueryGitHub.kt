package com.example.sbotlevskyi.myhelps.rest

import android.util.Log
import com.example.sbotlevskyi.myhelps.utils.Constants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QueryGitHub {
    private var restCommands = RESTcommands().apply {
        baseUrl = KeyValue.baseUrl
    }

    fun searchRepo(query: String, page: Int, per_page: Int) {
        restCommands.apply {
            endPoint = KeyValue.endPointRepo
            mapper = RepoMapper()
            params = repoParams(query, page, per_page)
        }
        query(restCommands)
    }

    private fun usersParams(locationVal: String, languageVal: String, page: Int, per_page: Int): MutableMap<String, Any> {
        return mutableMapOf(
                "q" to "location:$locationVal+language:$languageVal",
                "page" to page,
                "per_page" to per_page
        )
    }

    fun searchUsers(locationVal: String, languageVal: String, page: Int, per_page: Int) {
        restCommands.apply {
            endPoint = KeyValue.endPointUser
            baseUrl = KeyValue.baseUrl
            mapper = UserMapper()
            params = usersParams(locationVal, languageVal, page, per_page)
        }
        query(restCommands)
    }

    fun repoParams(q: String, page: Int, per_page: Int): MutableMap<String, Any> {
        return mutableMapOf(
                "q" to q,
                "page" to page,
                "per_page" to per_page
        )
    }

    private fun query(restCommands: RESTcommands) {
        val apiService = GithubApiService.Factory.create(restCommands.baseUrl)
        apiService.search(
                endPoint = restCommands.endPoint,
                queryMap = restCommands.params
        )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(
                        { t ->
                            restCommands.mapper.map(t.string())
                        },
                        { error: Throwable ->
                            Log.i(Constants.TAG, "rest manager error message: ${error.message}")
                        })
    }
}