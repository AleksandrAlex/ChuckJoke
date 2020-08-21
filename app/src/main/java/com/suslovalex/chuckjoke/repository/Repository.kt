package com.suslovalex.chuckjoke.repository

import com.suslovalex.chuckjoke.model.Post
import com.suslovalex.chuckjoke.retrofit.ChuckApi
import retrofit2.Response

class Repository {

    suspend fun getJoke(number: String): Response<Post> {
        return ChuckApi.retrofitService.getJoke(number)
    }
}