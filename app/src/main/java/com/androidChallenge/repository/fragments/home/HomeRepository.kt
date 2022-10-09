package com.androidChallenge.repository.fragments.home

import com.androidChallenge.di.database.entity.UserEntity
import io.reactivex.Single

interface HomeRepository {
    fun getUsers():Single<List<UserEntity>>
}