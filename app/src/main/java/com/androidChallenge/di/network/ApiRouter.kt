package com.androidChallenge.di.network

import com.androidChallenge.models.images.Image
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Query

interface ApiRouter {
    @GET("/api")
    fun getImages(
        @Query("key") apikey: String,
        @Query("q") query: String,
        @Query("image_type") image_type: String,
        @Query("pretty") pretty: String,
        @Query("per_page") per_page: Int,
        @Query("page") page: Int,
    ): Single<Image>
}