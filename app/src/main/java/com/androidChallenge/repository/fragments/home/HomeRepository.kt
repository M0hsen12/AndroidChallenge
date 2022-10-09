package com.androidChallenge.repository.fragments.home

import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.models.images.Image
import io.reactivex.Observable
import io.reactivex.Single

interface HomeRepository {
    fun getImages(apikey: String,
                  query: String,
                  image_type: String,
                  pretty: String,
                  per_page: Int,
                  page: Int):Single<Image>
}