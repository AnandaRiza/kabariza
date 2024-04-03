package com.example.kabariza.presentation.home_screen.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kabariza.R
import com.example.kabariza.databinding.ActivityHomeBinding
import com.example.kabariza.presentation.newshealth_screen.view.HealthFragment
import com.example.kabariza.presentation.newssport_screen.view.NewsSportFragment
import com.example.kabariza.presentation.newstech_screen.view.TechFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_sport -> {

                    // Show the Sport fragment
                    replaceFragment(NewsSportFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_health -> {
                    replaceFragment(HealthFragment())// Show the Health fragment
                    return@OnNavigationItemSelectedListener true
                }
                R.id.action_technology -> {
                    replaceFragment(TechFragment()) // Show the Technology fragment
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        replaceFragment(HomeFragment())
        binding.bottomNavigationViewact.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )

        if (savedInstanceState == null) {
            binding.bottomNavigationViewact.selectedItemId = R.id.action_sport
        }
//        val loadingProgressBar = binding.loadingProgressBar
//            BottomNavigationView.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                // Show ProgressBar when changing tab
//                loadingProgressBar.visibility = View.VISIBLE
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//                super.onPageScrollStateChanged(state)
//                if (state == ViewPager2.SCROLL_STATE_IDLE) {
//                    // Hide ProgressBar when tab change is complete
//                    loadingProgressBar.visibility = View.GONE
//                }
//            }
//        })
//

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.Fragment_Container, fragment).commit()
    }


}