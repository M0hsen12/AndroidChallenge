package com.androidChallenge.di.network


import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)// Set connection timeout
            .readTimeout(40, TimeUnit.SECONDS)// Read timeout
            .writeTimeout(40, TimeUnit.SECONDS)// Write timeout
            .cache(null)


        return builder.build()

    }

    @RestApi
    @Provides
    @Singleton
    fun provideRestApi(
        context: Context,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("Https://google.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RestApi

}
