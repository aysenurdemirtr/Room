package com.example.room.ui.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.entitys.album.Album

class AlbumAdapter(private var album: List<Album>) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userIdText: TextView = itemView.findViewById(R.id.userId_text)
        val idText: TextView = itemView.findViewById(R.id.id_text)
        val titleText: TextView = itemView.findViewById(R.id.title_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = album[position]

        holder.userIdText.text = "USER ID : ${album.userId}"
        holder.idText.text = "ID : ${album.id}"
        holder.titleText.text = "TITLE : ${album.title}"
    }

    override fun getItemCount(): Int {
        return album.size
    }

    fun setAlbum(album: List<Album>) {
        this.album = album
        notifyDataSetChanged()
    }
}