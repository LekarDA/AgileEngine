package com.example.agileengine.repository

import com.example.agileengine.Utils
import com.example.agileengine.data.Auth
import com.example.agileengine.data.DetailPicture
import com.example.agileengine.data.Image
import com.example.agileengine.network.ApiService
import java.lang.StringBuilder
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    suspend fun getListOfPhotos(page: Int): List<Image>? {
        val authResponse = safeApiCall(
            call = {
                apiService.auth(Auth(Utils.API_KEY)).await()
            },
            errorMessage = "Error Fetching Token"
        )
        bearerToken = StringBuilder().append("Bearer ").append(authResponse?.token).toString()
        val picturesResponse = safeApiCall(
            call = {
                apiService.getPictures(page, bearerToken).await()
            },
            errorMessage = "Error Fetching ListPhotos"
        )
        return picturesResponse?.list
    }

    suspend fun getDetailPhoto(id: String?): DetailPicture? {
        val picturesResponse = safeApiCall(
            call = {
                apiService.getDetailPicture(id, bearerToken).await()
            },
            errorMessage = "Error Fetching DetailPhoto"
        )
        return picturesResponse
    }

    companion object{
        var bearerToken :String? = null
    }
}