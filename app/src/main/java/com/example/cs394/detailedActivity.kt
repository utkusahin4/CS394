package com.example.cs394

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class detailedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        val album_cover : ImageView = findViewById(R.id.album_cover2);
        val album_name : TextView = findViewById(R.id.album_name2);
        val songFeatures : TextView = findViewById(R.id.songFeatures);

        val bundle : Bundle ?= intent.extras

        val coverId = bundle!!.getInt("album_cover")
        val names = bundle.getString("album_name")
        val songs = bundle.getString("songFeatures")


        album_cover.setImageResource(coverId)
        album_name.text = names;
        songFeatures.text = songs;
    }
}