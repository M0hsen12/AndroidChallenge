package com.androidChallenge.repository.fragments.details

import com.androidChallenge.di.database.DatabaseManager
import com.androidChallenge.di.network.NetworkManager
import com.androidChallenge.models.images.Image
import io.reactivex.Single

class DetailsRepositoryImpl(
    val networkManager: NetworkManager,
    val databaseManager: DatabaseManager
) :
    DetailsRepository {
    override fun getImages(
        apikey: String,
        query: String,
        image_type: String,
        pretty: String,
        per_page: Int,
        page: Int
    ): Single<Image> {
        return networkManager.getApiRoute()
            .getImages(apikey, query, image_type, pretty, per_page, page)
    }
}