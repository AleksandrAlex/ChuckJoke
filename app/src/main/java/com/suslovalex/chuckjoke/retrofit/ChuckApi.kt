package com.suslovalex.chuckjoke.retrofit

import com.suslovalex.chuckjoke.model.Post
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.icndb.com/jokes/random/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ChuckApiService {
    @GET("{amountOfJokes}")
    suspend fun getJoke(@Path ("amountOfJokes") number: String): Response<Post>
}

    object ChuckApi {
        val retrofitService: ChuckApiService by lazy {
            retrofit.create(ChuckApiService::class.java)
        }
    }
