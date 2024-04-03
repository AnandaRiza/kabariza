package com.example.kabariza.presentation.newssport_screen.view

import Article
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.kabariza.base.BaseFragment
import com.example.kabariza.databinding.FragmentHomeBinding
import com.example.kabariza.databinding.FragmentSportBinding
import com.example.kabariza.presentation.home_screen.adapter.HomeAdapter
import com.example.kabariza.presentation.newssport_screen.adapter.NewsSportAdapter
import com.example.kabariza.presentation.newssport_screen.view_model.NewsSportViewModel
import com.example.kabariza.utils.NewsItemClickListener
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsSportFragment : BaseFragment<FragmentSportBinding>(), NewsItemClickListener {
    private lateinit var sportNewsAdapter: NewsSportAdapter
    private val viewmodel: NewsSportViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSportBinding {
        return FragmentSportBinding.inflate(inflater, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupView()
//    }

    override fun setupView() {
        viewmodel.getSportNews()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewmodel.homeNewsSport.observe(viewLifecycleOwner) {
            setUpViewSport(it.articles)
        }
    }

    private fun setUpViewSport(data: List<Article>?) {
        sportNewsAdapter = NewsSportAdapter(
            sportdata = data ?: listOf(),
            context = binding.root.context,
            newsItemClickListener = this


        )
        binding.componentSport.rvNewsList.adapter = sportNewsAdapter



    }

    override fun onNewsItemClickListener(url: String) {
        val intent = Intent(requireContext(), NewsSportActivity::class.java)
        intent.putExtra("url",url)
        startActivity(intent)    }
}
