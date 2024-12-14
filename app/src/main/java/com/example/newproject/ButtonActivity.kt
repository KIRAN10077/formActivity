package com.example.newproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newproject.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {

    lateinit var binding: ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavigate.setOnClickListener{

            val username : String = binding.editUsername.text.toString()
            val password: String = binding.editPasscode.text.toString()

            if(username.isEmpty()){
                binding.editUsername.error = "username cannot be empty"
            }else if(password.isEmpty()){
                binding.editPasscode.error = "password cannot be empty"
            }else {
                val intent = Intent(this@ButtonActivity, DestinationActivity::class.java)

                intent.putExtra("username", username)
                intent.putExtra("password", password)
                
                startActivity(intent)

            }
            }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}