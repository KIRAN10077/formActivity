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
import com.example.newproject.databinding.ActivityNavigationBinding
import com.example.newproject.ui.fragment.HomeFragment
import com.example.newproject.ui.fragment.NotificationFragment
import com.example.newproject.ui.fragment.PersonFragment
import com.example.newproject.ui.fragment.SearchFragment

class NavigationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnItemSelectedListener{menu->
            when(menu.itemId) {
                R.id.navHome -> replaceFragment(HomeFragment())
                R.id.navSearch -> replaceFragment(SearchFragment())
                R.id.navPerson -> replaceFragment(PersonFragment())
                R.id.navNotification -> replaceFragment(NotificationFragment())
                else ->{}
            }
            true
        }


    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()    //these two lines are essential

        fragmentTransaction.replace(R.id.frameNavigation, fragment)
        fragmentTransaction.commit()
    }
}