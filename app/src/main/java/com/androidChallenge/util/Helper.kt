package com.androidChallenge.util

import com.androidChallenge.di.database.entity.UserEntity

fun entityMapper(email: String, password: String, age: Int) =
    UserEntity(
        email = email,
        password = password,
        age = age
    )