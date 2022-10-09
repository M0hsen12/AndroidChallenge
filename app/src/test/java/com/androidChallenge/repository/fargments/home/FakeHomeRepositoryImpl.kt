package com.androidChallenge.repository.fargments.home

import com.androidChallenge.di.NetworkMangerTest
import com.androidChallenge.models.images.HitsItem
import com.androidChallenge.models.images.Image
import com.androidChallenge.repository.fragments.home.HomeRepository
import io.reactivex.Single

class FakeHomeRepositoryImpl(){

    lateinit var getImages: List<HitsItem>
    lateinit var networkMangerTest: NetworkMangerTest

    fun build(){
        this.javaClass.classLoader?.let {
            networkMangerTest = NetworkMangerTest(it)
            networkMangerTest.build()
            getImages = networkMangerTest.produceListOfImages()
        }

    }
    fun getImages() = getImages
}