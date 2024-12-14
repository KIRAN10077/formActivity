package com.example.newproject

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newproject.databinding.ActivityButtonBinding
import com.example.newproject.databinding.ActivityDestinationBinding
import com.example.newproject.databinding.ActivityLoginPageBinding

class LoginPageActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{

            val username : String = binding.editFullname.text.toString()
            val email: String = binding.editEmailAddress.text.toString()
            val country = binding.countrySpinner.selectedItem.toString()
            val gender = when (binding.radioGroup.checkedRadioButtonId) {
                R.id.maleRadioBtn -> "Male"
                R.id.femaleRadioBtn -> "Female"
                else -> "Not Specified" // Default value if no gender is selected
            }
            val iAgree = binding.checkBox.isChecked

            if(username.isEmpty()){
                binding.editFullname.error = "username cannot be empty"
            } else if(email.isEmpty()){
                binding.editEmailAddress.error = "email cannot be empty"
            } else if(!iAgree){
                binding.checkBox.error = "Please agree to the terms and conditions first!"
            }
            else{
                val intent = Intent(this@LoginPageActivity, NextPageActivity::class.java)

                intent.putExtra("username", username)
                intent.putExtra("email", email)
                intent.putExtra("country", country)
                intent.putExtra("gender", gender)
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