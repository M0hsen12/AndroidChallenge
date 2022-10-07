package com.androidChallenge.di.modules

import com.androidChallenge.di.network.NetworkModule
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module(
    includes = [
        NetworkModule::class
    ]
)
open class AppModule {

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }



}