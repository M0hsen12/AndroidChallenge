package com.androidChallenge.di

import com.androidChallenge.models.images.HitsItem

class DependencyContainer {

    lateinit var getImages: List<HitsItem>
    lateinit var networkMangerTest: NetworkMangerTest
    fun build() {
        this.javaClass.classLoader?.let {
            networkMangerTest = NetworkMangerTest(it)
            networkMangerTest.build()
            getImages = networkMangerTest.produceListOfImages()
        }
    }

    fun setUpListForException() {
        getImages.first().id = THROW_EXCEPTION_ID
    }

    companion object {
        const val THROW_EXCEPTION_ID = -1
        const val EXCEPTION_MSG = "Exception on method"
    }
}