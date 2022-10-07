package com.androidChallenge.di.database.entity

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "users")
class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Long? = null,

    @ColumnInfo(name = "Email")
    var name: String? = null,

    @ColumnInfo(name = "Password")
    var appLinkIntentUri: String? = null,

    @ColumnInfo(name = "Age")
    var description: Int? = null

)



