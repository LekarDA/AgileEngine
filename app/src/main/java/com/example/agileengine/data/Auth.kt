package com.example.agileengine.data

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("apiKey")
    val key: String
    )