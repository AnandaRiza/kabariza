package com.example.kabariza.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kabariza.base.BaseFragment
import com.example.kabariza.databinding.FragmentHomeBinding
import com.example.kabariza.presentation.home_screen.adapter.HomeAdapter
import com.example.kabariza.presentation.newssport_screen.adapter.NewsSportAdapter
import com.example.kabariza.presentation.newssport_screen.view.NewsSportFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :  BaseFragment<FragmentHomeBinding>() {
    private var adapterHome :HomeAdapter? = null
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        val tabLayout = binding.tabHome
        val viewPager = binding.vpNews
        adapterHome = HomeAdapter(this)
        adapterHome?.addListFragment(NewsSportFragment())
        viewPager.adapter = adapterHome

        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            when(position) {
                0 -> {
                    tab.text = "sport"
                }

            }
        }.attach()    }
}