package com.androidChallenge.models.images

import com.google.gson.annotations.SerializedName

data class Image(@SerializedName("hits")
                 val hits: List<HitsItem>?,
                 @SerializedName("total")
                 val total: Int = 0,
                 @SerializedName("totalHits")
                 val totalHits: Int = 0)