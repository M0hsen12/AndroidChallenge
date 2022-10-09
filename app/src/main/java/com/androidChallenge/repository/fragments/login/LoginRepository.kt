package com.androidChallenge.repository.fragments.login

import com.androidChallenge.di.database.entity.UserEntity
import io.reactivex.Single

interface LoginRepository {
    fun getUsers(): Single<List<UserEntity>>

    fun getUserByEmail(email: String): Single<UserEntity>
}