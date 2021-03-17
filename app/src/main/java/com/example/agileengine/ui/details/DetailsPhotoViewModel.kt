package com.example.agileengine.ui.details

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agileengine.data.DetailPicture
import com.example.agileengine.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailsPhotoViewModel @ViewModelInject constructor(private val repository : Repository):
    ViewModel() {
    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)
    val detailPhotoLiveData = MutableLiveData<DetailPicture>()

    fun getPhoto(id:String?){
        scope.launch {
            val detailPhoto = repository.getDetailPhoto(id)
            detailPhotoLiveData.postValue(detailPhoto)
        }
    }
}