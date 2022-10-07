package com.androidChallenge.di.component

import android.content.Context
import com.androidChallenge.App
import com.androidChallenge.di.modules.ActivityInjectorsModule
import com.androidChallenge.di.modules.AppModule
import com.androidChallenge.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityInjectorsModule::class,
        RepositoryModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)



}

