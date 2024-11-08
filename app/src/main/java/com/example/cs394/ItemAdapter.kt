package com.example.cs394

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val context : Context, private val songList : List<Song>)
    : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }


    class ItemViewHolder(private val view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.album_cover)

        val textView2: TextView = view.findViewById(R.id.album_name)


        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.song_item, parent, false)
        return ItemViewHolder(itemView, mListener);
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = songList[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textView2.text = currentItem.name

    }
}

