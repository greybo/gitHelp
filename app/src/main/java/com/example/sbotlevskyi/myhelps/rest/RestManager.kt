package com.example.sbotlevskyi.myhelps.rest

import android.util.Log
import com.example.sbotlevskyi.myhelps.model.Result
import com.example.sbotlevskyi.myhelps.utils.Constants.TAG
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

class RestManager {


}

class RESTcommands {
    lateinit var baseUrl: String
    lateinit var mapper: Mapper
    lateinit var endPoint: String
    lateinit var params: MutableMap<String, Any>


}


interface Mapper {
    fun map(json: String)
}

class UserMapper : Mapper {
    override fun map(json: String) {
        Log.i(TAG, "UserMapper: $json")
    }
}

class RepoMapper : Mapper {
    override fun map(json: String) {
        Log.i(TAG, "RepoMapper: $json")
    }
}

interface GithubApiService {

    @GET("search/{endPoint}")
    fun search(
            @Path("endPoint") endPoint: String,
            @QueryMap queryMap: MutableMap<String, Any>
    ): Observable<ResponseBody>

    /**
     * Factory class for convenient creation of the Api Service interface
     */
    object Factory {

        fun create(url: String): GithubApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(url)
                    .build()

            return retrofit.create(GithubApiService::class.java)
        }
    }
}

object KeyValue {
    const val baseUrl = "https://api.github.com/"
    const val location = "Omsk"
    const val language = "Java"
    const val endPointRepo = "repositories"
    const val endPointUser = "user"
    var page: Int = 1
    var perPage: Int = 10
}

object NameField {
    const val LOCATION = "location"
    const val LANGUAGE = "language"
//    const val END_POINT = "endPoint"

}