package com.androidChallenge.di.database.dao


import androidx.room.*
import com.androidChallenge.di.database.entity.UserEntity
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(programEntity: UserEntity): Single<Long>

    @Query("SELECT * FROM users WHERE `id` = :id LIMIT 1")
    abstract fun findUserById(id: Long?): UserEntity?

    @Query("SELECT * FROM users WHERE `email` = :email LIMIT 1")
    abstract fun findUserByEmail(email: String): Single<UserEntity>

    @Query("DELETE FROM users")
    abstract fun deleteAll()

    @Query("DELETE FROM users WHERE `id` = :id")
    abstract fun delete(id: Long)

    @Query("SELECT * FROM users")
    abstract fun findAll(): Single<List<UserEntity>>
}

