package com.example.kabariza.presentation.home_screen.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
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
    private lateinit var loadingProgressBar: ProgressBar
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_sport -> {
                    loadingProgressBar.visibility = View.VISIBLE // Show loading progress bar
                    replaceFragment(NewsSportFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.action_health -> {
                    loadingProgressBar.visibility = View.VISIBLE // Show loading progress bar
                    replaceFragment(HealthFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.action_technology -> {
                    loadingProgressBar.visibility = View.VISIBLE // Show loading progress bar
                    replaceFragment(TechFragment())
                    return@OnNavigationItemSelectedListener true
                }

                else -> false
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingProgressBar = binding.loadingProgressBar
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
        loadingProgressBar.visibility = View.VISIBLE

        supportFragmentManager.beginTransaction().replace(R.id.Fragment_Container, fragment)
            .commit()

        fragment.viewLifecycleOwnerLiveData.observe(this, { viewLifecycleOwner ->
            viewLifecycleOwner?.lifecycle?.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                fun onDestroy() {
                    loadingProgressBar.visibility = View.GONE
                }
            })
        })
    }


}