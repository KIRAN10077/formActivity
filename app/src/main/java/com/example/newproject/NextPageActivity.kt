package com.example.newproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newproject.databinding.ActivityDestinationBinding
import com.example.newproject.databinding.ActivityLoginPageBinding
import com.example.newproject.databinding.ActivityNextPageBinding

class NextPageActivity : AppCompatActivity() {

    lateinit var binding: ActivityNextPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityNextPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username: String = intent.getStringExtra("username").toString()
        val email: String = intent.getStringExtra("email").toString()
        val country: String = intent.getStringExtra("country").toString()
        val gender: String = intent.getStringExtra("gender").toString()

        binding.outputFullName.text = username
        binding.outputEmailAddress.text = email
        binding.outputCountry.text = country
        binding.outputGender.text = gender
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}