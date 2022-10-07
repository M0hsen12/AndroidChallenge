package com.androidChallenge.di.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface ApiRouter {
    @GET("images")
    fun getImages(@Body coordinatesBody: String): Single<List<String>>
}