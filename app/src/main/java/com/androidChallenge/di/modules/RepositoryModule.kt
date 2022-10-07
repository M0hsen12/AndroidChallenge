package com.androidChallenge.di.modules

import com.androidChallenge.di.database.DatabaseManager
import com.androidChallenge.di.network.NetworkManager
import com.androidChallenge.repository.activities.MainActivityRepository
import com.androidChallenge.repository.activities.MainActivityRepositoryImpl
import com.androidChallenge.repository.fragments.details.DetailsRepository
import com.androidChallenge.repository.fragments.details.DetailsRepositoryImpl
import com.androidChallenge.repository.fragments.login.LoginRepository
import com.androidChallenge.repository.fragments.login.LoginRepositoryImpl
import com.androidChallenge.repository.fragments.signup.SignupRepository
import com.androidChallenge.repository.fragments.signup.SignupRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainActivityRepository(networkManager: NetworkManager,databaseManager: DatabaseManager): MainActivityRepository {
        return MainActivityRepositoryImpl(networkManager,databaseManager)
    }

    @Provides
    @Singleton
    fun provideDetailsRepository(networkManager: NetworkManager,databaseManager: DatabaseManager): DetailsRepository {
        return DetailsRepositoryImpl(networkManager,databaseManager)
    }
    @Provides
    @Singleton
    fun provideLoginRepository(networkManager: NetworkManager,databaseManager: DatabaseManager): LoginRepository {
        return LoginRepositoryImpl(networkManager,databaseManager)
    }
    @Provides
    @Singleton
    fun provideSignupRepository(networkManager: NetworkManager,databaseManager: DatabaseManager): SignupRepository {
        return SignupRepositoryImpl(networkManager,databaseManager)
    }
}