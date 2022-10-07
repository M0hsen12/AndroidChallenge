package com.androidChallenge.di.network

import retrofit2.Retrofit
import javax.inject.Inject


class NetworkManager @Inject constructor(
    @NetworkModule.RestApi private val retrofitRestApi: Retrofit
) {

    fun <T> create(tClass: Class<T>): T {
        return retrofitRestApi.create(tClass)
    }

    fun getApiRoute(): ApiRouter {
        return retrofitRestApi.create(ApiRouter::class.java)
    }

}
