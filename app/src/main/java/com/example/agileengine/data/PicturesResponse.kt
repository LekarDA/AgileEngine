package com.example.agileengine.data

import com.google.gson.annotations.SerializedName

data class PicturesResponse(
    @SerializedName("pictures")
    val list: List<Image>,
    @SerializedName("page")
    val page: Integer,
    @SerializedName("pageCount")
    val pageCount: Integer,
    @SerializedName("hasMore")
    val hasMore: Boolean
)
