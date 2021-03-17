package com.example.agileengine.ui.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.agileengine.R
import com.example.agileengine.data.Image
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view.view.*

class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun initView(photo: Image) {
        Picasso.get().load(photo.picture)
            .placeholder(R.drawable.ic_no_photo).into(itemView.photo)
    }
}