package com.example.newproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity() {
    lateinit var backImage: ImageView
    lateinit var yourFries: TextView
    lateinit var deserveBetter: TextView
    lateinit var tomatoBasil: TextView
    lateinit var fName: EditText
    lateinit var lName: EditText
    lateinit var userEmail: EditText
    lateinit var userPassword: EditText
    lateinit var signupButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)

        backImage = findViewById(R.id.imageView3)
        yourFries = findViewById(R.id.textView1)
        deserveBetter = findViewById(R.id.textView9)
        tomatoBasil = findViewById(R.id.textView)
        fName = findViewById(R.id.editFirstName)
        lName = findViewById(R.id.editLastName)
        userEmail = findViewById(R.id.editEmail)
        userPassword = findViewById(R.id.editPassword)
        signupButton = findViewById(R.id.buttonSubmit)





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.webView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}