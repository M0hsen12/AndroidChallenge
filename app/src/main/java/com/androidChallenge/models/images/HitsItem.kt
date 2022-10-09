package com.androidChallenge.models.images

import android.os.Parcelable
import android.util.Log
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.text.DecimalFormat

@Parcelize
data class HitsItem(
    @SerializedName("webformatHeight")
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
    var id: Int = 0,
    @SerializedName("imageSize")
    val imageSize: Int = 0,
    @SerializedName("webformatWidth")
    val webformatWidth: Int = 0,
    @SerializedName("user")
    val user: String = "",
    @SerializedName("views")
    val views: Int = 0,
    @SerializedName("likes")
    val likes: Int = 0
) : Parcelable {
    fun getImageSizeWithKB() = "Size : $imageSize KB"
    fun getImageSizeWithMG(): String {
        return "Size : ${DecimalFormat("#0.00").format(imageSize.toDouble().div(1024 * 1024))} MG"

    }

    fun getImageTypeWithPrefix() = "Type : $type"
    fun getImageTagsWithPrefix() = "Tags : $tags"
    fun getUploaderName() = "Uploader : $user"
    fun amountOfViews() = "Views : $views"
    fun amountOfLikes() = "Likes : $likes"
    fun amountOfComments() = "Comments : $comments"
    fun amountOfDownloads() = "Downloads : $downloads"
    fun amountOfFavorites() = "Favorites : $collections"

}
