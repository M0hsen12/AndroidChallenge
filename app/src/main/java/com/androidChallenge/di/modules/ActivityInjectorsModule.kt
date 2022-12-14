package com.androidChallenge.di.modules

import com.androidChallenge.view.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityInjectorsModule {


    @ContributesAndroidInjector
    abstract fun mainActivityInjector(): MainActivity


}