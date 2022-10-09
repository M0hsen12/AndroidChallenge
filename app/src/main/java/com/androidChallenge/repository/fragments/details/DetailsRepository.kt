package com.androidChallenge.repository.fragments.details

import com.androidChallenge.models.images.Image
import io.reactivex.Single

interface DetailsRepository {
    fun getImages(apikey: String,
                  query: String,
                  image_type: String,
                  pretty: String,
                  per_page: Int,
                  page: Int): Single<Image>
}