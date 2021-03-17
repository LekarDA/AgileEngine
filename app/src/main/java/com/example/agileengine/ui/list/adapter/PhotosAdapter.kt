package com.example.agileengine.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agileengine.R
import com.example.agileengine.data.Image

class PhotosAdapter: RecyclerView.Adapter<PhotoViewHolder>() {

    private val listOfPhotos: ArrayList<Image> = ArrayList()
    private var listener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.initView(listOfPhotos[position])
        holder.itemView.setOnClickListener {
            listener?.onItemClick(listOfPhotos[holder.adapterPosition])
        }
    }

    override fun getItemCount() = listOfPhotos.size

    fun setData(artists: List<Image>){
        listOfPhotos.clear()
        listOfPhotos.addAll(artists)
        notifyDataSetChanged()
    }

    fun setItemClickListener(clicklistener: ItemClickListener?) {
        this.listener = clicklistener
    }
}