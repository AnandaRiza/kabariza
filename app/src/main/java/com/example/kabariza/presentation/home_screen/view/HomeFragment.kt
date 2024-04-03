package com.example.kabariza.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.kabariza.R
import com.example.kabariza.base.BaseFragment
import com.example.kabariza.databinding.FragmentHomeBinding
import com.example.kabariza.presentation.home_screen.adapter.HomeAdapter
import com.example.kabariza.presentation.newshealth_screen.view.HealthFragment
import com.example.kabariza.presentation.newssport_screen.adapter.NewsSportAdapter
import com.example.kabariza.presentation.newssport_screen.view.NewsSportFragment
import com.example.kabariza.presentation.newstech_screen.view.TechFragment
import com.example.kabariza.utils.ReplaceFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :  BaseFragment<FragmentHomeBinding>(){
    private var adapterHome :HomeAdapter? = null

//    private val onNavigationItemSelectedListener =
//        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
//        when (menuItem.itemId) {
//            R.id.action_sport -> {
//
//                // Show the Sport fragment
//
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.action_health -> {
//                viewPager.setCurrentItem(1, false) // Show the Health fragment
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.action_technology -> {
//                viewPager.setCurrentItem(2, false) // Show the Technology fragment
//                return@OnNavigationItemSelectedListener true
//            }
//            else -> false
//        }
//    }
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
//        val tabLayout = binding.
//        val viewPager = binding.vpNews
        val loadingProgressBar = binding.loadingProgressBar
//
//        adapterHome = HomeAdapter(this)
//        adapterHome?.addListFragment(NewsSportFragment())
//        adapterHome?.addListFragment(HealthFragment())
//        adapterHome?.addListFragment(TechFragment())
//        viewPager.adapter = adapterHome
//
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            when (position) {
//                0 -> {
//                    tab.text = "Sport"
//                }
//
//                1 -> {
//                    tab.text = "Health"
//                }
//
//                2 -> {
//                    tab.text = "Technology"
//                }
//            }
//        }.attach()



//
//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
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
    }

    }