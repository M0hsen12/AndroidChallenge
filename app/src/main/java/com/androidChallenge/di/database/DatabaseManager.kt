package com.androidChallenge.di.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.androidChallenge.di.database.dao.UserDao
import com.androidChallenge.di.database.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)

abstract class DatabaseManager : RoomDatabase() {

    abstract fun userDao(): UserDao


}