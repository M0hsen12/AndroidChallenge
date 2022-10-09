package com.androidChallenge.repository.activities

import com.androidChallenge.di.database.entity.UserEntity
import io.reactivex.Single

interface MainActivityRepository {
    fun getUserDetail(email: String): Single<UserEntity>
}