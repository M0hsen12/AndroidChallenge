package com.androidChallenge.viewmodel.fragments.home

import com.androidChallenge.models.images.HitsItem
import com.androidChallenge.repository.fargments.home.FakeHomeRepositoryImpl

class FakeHomeViewModel {
    private lateinit var getImages: List<HitsItem>
    lateinit var homeRepository: FakeHomeRepositoryImpl

    fun build() {
        homeRepository = FakeHomeRepositoryImpl()
        homeRepository.build()
        getImages = homeRepository.getImages()
    }

    fun getImageList() = getImages

    fun setUpImageForException(){
        getImages.first().id == THROW_EXCEPTION_ID
    }
    companion object {
        const val THROW_EXCEPTION_ID = -1
        const val EXCEPTION_MSG = "Exception on method"
    }
}