package com.example.agileengine.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    @SerializedName("id")
    val id: String,
    @SerializedName("cropped_picture")
    val picture: String
    ):Parcelable
