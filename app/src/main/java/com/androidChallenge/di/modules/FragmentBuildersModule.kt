package com.androidChallenge.di.modules

import com.androidChallenge.view.fragments.details.FragmentDetails
import com.androidChallenge.view.fragments.home.FragmentHome
import com.androidChallenge.view.fragments.login.FragmentLogin
import com.androidChallenge.view.fragments.signup.FragmentSignup
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun fragmentDetailsInjector(): FragmentDetails

    @ContributesAndroidInjector()
    abstract fun fragmentLoginInjector(): FragmentLogin

    @ContributesAndroidInjector()
    abstract fun fragmentSignupInjector(): FragmentSignup

    @ContributesAndroidInjector()
    abstract fun fragmentHomeInjector(): FragmentHome
}