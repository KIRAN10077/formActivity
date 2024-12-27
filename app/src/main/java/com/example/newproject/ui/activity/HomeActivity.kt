package com.example.newproject.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.newproject.R
import com.example.newproject.databinding.ActivityHomeBinding
import com.example.newproject.ui.fragment.FirstFragment
import com.example.newproject.ui.fragment.SecondFragment

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(FirstFragment())
        binding.btnFirstScreen.setOnClickListener{
            replaceFragment(FirstFragment())
        }

        binding.btnSecondScreen.setOnClickListener{
            replaceFragment(SecondFragment())
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
            }
        }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()    //these two lines are essential

        fragmentTransaction.replace(binding.frameLayout.id, Fragment())
        fragmentTransaction.commit()
    }
}