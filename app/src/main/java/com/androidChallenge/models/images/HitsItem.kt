package com.androidChallenge.models.images

import com.google.gson.annotations.SerializedName

data class HitsItem(@SerializedName("webformatHeight")
                    val webformatHeight: Int = 0,
                    @SerializedName("imageWidth")
                    val imageWidth: Int = 0,
                    @SerializedName("previewHeight")
                    val previewHeight: Int = 0,
                    @SerializedName("webformatURL")
                    val webformatURL: String = "",
                    @SerializedName("userImageURL")
                    val userImageURL: String = "",
                    @SerializedName("previewURL")
                    val previewURL: String = "",
                    @SerializedName("comments")
                    val comments: Int = 0,
                    @SerializedName("type")
                    val type: String = "",
                    @SerializedName("imageHeight")
                    val imageHeight: Int = 0,
                    @SerializedName("tags")
                    val tags: String = "",
                    @SerializedName("previewWidth")
                    val previewWidth: Int = 0,
                    @SerializedName("downloads")
                    val downloads: Int = 0,
                    @SerializedName("collections")
                    val collections: Int = 0,
                    @SerializedName("user_id")
                    val userId: Int = 0,
                    @SerializedName("largeImageURL")
                    val largeImageURL: String = "",
                    @SerializedName("pageURL")
                    val pageURL: String = "",
                    @SerializedName("id")
                    val id: Int = 0,
                    @SerializedName("imageSize")
                    val imageSize: Int = 0,
                    @SerializedName("webformatWidth")
                    val webformatWidth: Int = 0,
                    @SerializedName("user")
                    val user: String = "",
                    @SerializedName("views")
                    val views: Int = 0,
                    @SerializedName("likes")
                    val likes: Int = 0)