package com.androidChallenge.repository.fragments.signup

import com.androidChallenge.di.database.entity.UserEntity
import io.reactivex.Single

interface SignupRepository {
    fun insertUser(userEntity: UserEntity):Single<Long>
}