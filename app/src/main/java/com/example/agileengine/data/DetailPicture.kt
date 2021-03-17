package com.example.agileengine.data

import com.google.gson.annotations.SerializedName

data class DetailPicture(
    @SerializedName("id")
    val id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("camera")
    val camera: String,
    @SerializedName("cropped_picture")
    val cropPicture: String,
    @SerializedName("full_picture")
    val fullPicture: String
)
