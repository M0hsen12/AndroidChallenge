package com.androidChallenge.repository.activities

import com.androidChallenge.di.database.DatabaseManager
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.di.network.NetworkManager
import io.reactivex.Single

class MainActivityRepositoryImpl(
    val networkManager: NetworkManager,
    val databaseManager: DatabaseManager
) : MainActivityRepository {
    override fun getUserDetail(email: String): Single<UserEntity> =
        databaseManager.userDao().findUserByEmail(email)
}