package com.example.newproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newproject.adapter.FruitsAdapter

class RecycleActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var imageList = ArrayList<Int>()
    var titleList = ArrayList<String>()
    var descList = ArrayList<String>()

    lateinit var adapter: FruitsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle)

        recyclerView = findViewById(R.id.recyclerView)

        imageList.add(R.drawable.applee)
        imageList.add(R.drawable.grapee)
        imageList.add(R.drawable.mangoo)

        titleList.add("Apple")
        titleList.add("Grape")
        titleList.add("Mango")

        descList.add("This is apple")
        descList.add("This is grape")
        descList.add("This is mango")

        adapter = FruitsAdapter(
            this@RecycleActivity,
            imageList, titleList, descList
        )

        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this@RecycleActivity)     //vertically dekhaune ho vane
        recyclerView.layoutManager = LinearLayoutManager(this@RecycleActivity, LinearLayoutManager.HORIZONTAL,false)  //horizontal dekhaune ho vane
//        recyclerView.layoutManager = GridLayoutManager(this@RecycleActivity,2)     //grid ma dekhaune ho vane
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}