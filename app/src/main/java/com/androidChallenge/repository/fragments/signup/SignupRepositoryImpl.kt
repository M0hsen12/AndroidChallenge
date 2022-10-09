package com.androidChallenge.repository.fragments.signup

import com.androidChallenge.di.database.DatabaseManager
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.di.network.NetworkManager
import io.reactivex.Single

class SignupRepositoryImpl(networkManager: NetworkManager,val  databaseManager: DatabaseManager):SignupRepository {
    override fun insertUser(userEntity: UserEntity): Single<Long>  =databaseManager.userDao().insert(userEntity)
}