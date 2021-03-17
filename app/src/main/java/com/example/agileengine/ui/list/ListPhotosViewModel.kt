package com.example.agileengine.ui.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.agileengine.data.Image
import com.example.agileengine.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListPhotosViewModel @ViewModelInject constructor(private val repository : Repository):
    ViewModel()  {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)
    val photosLiveData = MutableLiveData<List<Image>>()

    fun getPhotos(){
        scope.launch {
            val listOfPhotos = repository.getListOfPhotos(1)
            photosLiveData.postValue(listOfPhotos)
        }
    }
}