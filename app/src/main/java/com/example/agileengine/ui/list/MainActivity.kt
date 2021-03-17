package com.example.agileengine.ui.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.agileengine.*
import com.example.agileengine.data.Image
import com.example.agileengine.ui.details.DetailPhotoActivity
import com.example.agileengine.ui.list.adapter.ItemClickListener
import com.example.agileengine.ui.list.adapter.PhotosAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemClickListener {

    private val viewModel: ListPhotosViewModel by viewModels()
    private lateinit var photosAdapter: PhotosAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createList()
        viewModel.getPhotos()
        viewModel.photosLiveData.observe(this, Observer {
            photosAdapter.setData(it)
        })
    }

    private fun createList() {
        photosAdapter = PhotosAdapter()
        photosAdapter.setItemClickListener(this)
        val listlayoutManager = GridLayoutManager(this, 2)
        rvPhotos.apply {
            layoutManager = listlayoutManager
            setHasFixedSize(true)
            adapter = photosAdapter
        }
    }

    override fun onItemClick(image: Image) {
        val intent = Intent(this, DetailPhotoActivity::class.java).apply {
            putExtra(PHOTO, image)
        }
        startActivity(intent)
    }

    companion object{
        const val PHOTO = "PHOTO"
    }
}