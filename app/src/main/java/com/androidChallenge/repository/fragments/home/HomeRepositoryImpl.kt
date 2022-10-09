package com.androidChallenge.repository.fragments.home

import com.androidChallenge.di.database.DatabaseManager
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.di.network.NetworkManager
import com.androidChallenge.repository.fragments.details.DetailsRepository
import io.reactivex.Single

class HomeRepositoryImpl(val networkManager: NetworkManager,val databaseManager: DatabaseManager) :
    HomeRepository {
    override fun getUsers(): Single<List<UserEntity>> {
        return databaseManager.userDao().findAll()
    }

}