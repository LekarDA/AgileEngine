package com.example.agileengine.network

import com.example.agileengine.data.Auth
import com.example.agileengine.data.AuthResponse
import com.example.agileengine.data.DetailPicture
import com.example.agileengine.data.PicturesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("/auth")
    fun auth(@Body auth: Auth): Deferred<Response<AuthResponse>>

    @GET("/images")
    fun getPictures(
        @Query("page") page: Int,
        @Header("Authorization") token: String?
    ): Deferred<Response<PicturesResponse>>

    @GET("/images/{id}")
    fun getDetailPicture(
        @Path("id") id: String?,
        @Header("Authorization") token: String?
    ): Deferred<Response<DetailPicture>>
}