package com.example.newproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Radioactivity : AppCompatActivity() {
    lateinit var pepe1 : RadioButton
    lateinit var pepe2 : RadioButton
    lateinit var pepe3 : RadioButton
    lateinit var image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radioactivity)
        pepe1 = findViewById(R.id.radioPepe1)
        pepe2 = findViewById(R.id.radioPepe2)
        pepe3 = findViewById(R.id.radioPepe3)
        image = findViewById(R.id.imageView2)

        pepe1.setOnClickListener{
            image.setImageResource(R.drawable.pepe3)
        }
        pepe2.setOnClickListener{
            image.setImageResource(R.drawable.pepe2)
        }
        pepe3.setOnClickListener{
            image.setImageResource(R.drawable.pepe1)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.webView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}