package com.example.cs394

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cs394.ItemAdapter
import com.example.cs394.Song

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView;
    private lateinit var albumsList : ArrayList<Song>

    lateinit var album_covers : List<Int>
    lateinit var album_names : Array<String>
    lateinit var album_songs : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        album_covers = listOf(
            R.drawable.hey,
            R.drawable.boyver,
            R.drawable.galileo,
            R.drawable.istanbulda,
            R.drawable.kordugum,
            R.drawable.kukla,
            R.drawable.kulolana,
            R.drawable.lanet,
            R.drawable.mutsuzum,
            R.drawable.zombiler
        )


        album_names = resources.getStringArray(R.array.album_names)

        album_songs = resources.getStringArray(R.array.songFeatures)

        recyclerView = findViewById(R.id.MRV)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        albumsList = arrayListOf<Song>()
        loadAlbums();
    }

    private fun loadAlbums() {

        for(i in album_covers.indices){

            val album = Song(album_covers[i], album_names[i])
            albumsList.add(album)
        }

        var adapter = ItemAdapter(this, albumsList)
        recyclerView.adapter = adapter;
        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, detailedActivity::class.java)
                intent.putExtra("album_cover", albumsList[position].image)
                intent.putExtra("album_name", albumsList[position].name)
                intent.putExtra("songFeatures", album_songs[position])
                startActivity(intent)
            }
        })
    }
}