package com.androidChallenge.repository.fragments.home

import com.androidChallenge.di.database.DatabaseManager
import com.androidChallenge.di.database.entity.UserEntity
import com.androidChallenge.di.network.NetworkManager
import com.androidChallenge.models.images.Image
import com.androidChallenge.repository.fragments.details.DetailsRepository
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Query

class HomeRepositoryImpl(val networkManager: NetworkManager,val databaseManager: DatabaseManager) :
    HomeRepository {
    override fun getImages(apikey: String,
                            query: String,
                            image_type: String,
                            pretty: String,
                            per_page: Int,
                            page: Int): Single<Image> {
        return networkManager.getApiRoute().getImages(apikey, query, image_type, pretty, per_page, page)
    }

}