package com.example.agileengine.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthResponse (
    @SerializedName("auth") val auth : Boolean,
    @SerializedName("token") val token : String
    ):Parcelable