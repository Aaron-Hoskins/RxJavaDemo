package com.examples.coding.rxjavademo.datasource.remote.retrofit

import com.examples.coding.networkingdemoone.model.ChuckNorrisResponse.JokeResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.File

interface JokesService {
    //Static Objects in Kotlin
    companion object{
        fun getChuckNorrisJokeCallService() =
            RetrofitHelper.retrofitInstance.create(JokesService::class.java)
    }

    @GET("jokes/{type}")
    fun getRandomJokes(@Path("type") type: String)
            : Observable<JokeResponse>

}