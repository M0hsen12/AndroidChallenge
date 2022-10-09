package com.androidChallenge.di

import com.androidChallenge.models.images.HitsItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NetworkMangerTest(private val testClassLoader: ClassLoader) {

    lateinit var apiCallFakeTest: List<HitsItem>

    fun build() {
        apiCallFakeTest = produceListOfImages()
    }

    fun produceListOfImages(): List<HitsItem> {
        return Gson()
            .fromJson(
                getImagesFromFile("Image_list.json"),
                object : TypeToken<List<HitsItem>>() {}.type
            )
    }


    fun getImagesFromFile(fileName: String): String {
        return testClassLoader.getResource(fileName).readText()
    }


}