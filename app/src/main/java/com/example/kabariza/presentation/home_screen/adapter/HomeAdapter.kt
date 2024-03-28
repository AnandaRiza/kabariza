package com.example.kabariza.presentation.home_screen.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kabariza.base.BaseFragment

class HomeAdapter(
    fragment: Fragment,
): FragmentStateAdapter(
    fragment.childFragmentManager,
    fragment.lifecycle
) {

    private val fragmentContent = arrayListOf<Fragment>()

    fun addListFragment(fragment: Fragment){
        fragmentContent.add(fragment)
    }
    override fun getItemCount() = fragmentContent.size

    override fun createFragment(position: Int): Fragment {
        return fragmentContent[position]
    }




}