package com.example.agileengine.ui.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.agileengine.R
import com.example.agileengine.data.Image
import com.example.agileengine.ui.list.MainActivity
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.detail_activity.*

@AndroidEntryPoint
class DetailPhotoActivity : AppCompatActivity(){

    private val viewModel: DetailsPhotoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val photo = intent.getParcelableExtra<Image>(MainActivity.PHOTO)
        viewModel.getPhoto(photo?.id)
        viewModel.detailPhotoLiveData.observe(this, Observer {
            Picasso.get().load(it?.fullPicture)
                .placeholder(R.drawable.ic_no_photo).into(ivPhoto)
            tvAuthor.text = it.author
            tvCamera.text = it.camera
        })
    }
}