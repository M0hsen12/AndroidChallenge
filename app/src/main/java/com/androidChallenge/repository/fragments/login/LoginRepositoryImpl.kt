package com.androidChallenge.repository.fragments.login

import com.androidChallenge.di.database.DatabaseManager
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.di.network.NetworkManager
import io.reactivex.Single

class LoginRepositoryImpl(val networkManager: NetworkManager,val databaseManager: DatabaseManager):LoginRepository {
    override fun getUsers(): Single<List<UserEntity>> = databaseManager.userDao().findAll()
    override fun getUserByEmail(email: String)  =databaseManager.userDao().findUserByEmail(email)

}