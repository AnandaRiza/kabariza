package com.example.kabariza.presentation.newssport_screen.view

import Article
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.kabariza.base.BaseFragment
import com.example.kabariza.databinding.FragmentHomeBinding
import com.example.kabariza.databinding.FragmentSportBinding
import com.example.kabariza.presentation.home_screen.adapter.HomeAdapter
import com.example.kabariza.presentation.newssport_screen.adapter.NewsSportAdapter
import com.example.kabariza.presentation.newssport_screen.view_model.NewsSportViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsSportFragment : BaseFragment<FragmentSportBinding>() {
    private lateinit var sportNewsAdapter: NewsSportAdapter
    private val viewmodel: NewsSportViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSportBinding {
        return FragmentSportBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun setupView() {
        viewmodel.getSportNews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewmodel.homeNewsSport.observe(viewLifecycleOwner) { sportNews ->
            setUpViewSport(sportNews.articles)
        }
    }

    private fun setUpViewSport(data: List<Article>?) {
        sportNewsAdapter = NewsSportAdapter(
            sportdata = data ?: listOf(),
            context = requireContext()
        )
        binding.componentSport.rvNewsList.adapter = sportNewsAdapter
    }
}
