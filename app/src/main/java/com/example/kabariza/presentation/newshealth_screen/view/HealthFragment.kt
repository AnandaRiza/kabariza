package com.example.kabariza.presentation.newshealth_screen.view

import Article
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.kabariza.base.BaseFragment
import com.example.kabariza.databinding.FragmentHealthBinding
import com.example.kabariza.presentation.newshealth_screen.adapter.HealthAdapter
import com.example.kabariza.presentation.newshealth_screen.view_model.HealthViewModel
import com.example.kabariza.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HealthFragment : BaseFragment<FragmentHealthBinding>(), NewsItemClickListener{
    private lateinit var healthNewsAdapter: HealthAdapter
    private val viewmodel: HealthViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHealthBinding {
        return FragmentHealthBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewmodel.getNewsHealth()
        observeViewModel()

    }

    private fun observeViewModel() {
        viewmodel.homeHealthNews.observe(viewLifecycleOwner){
            setUpViewHealth(it.articles)
        }
    }

    private fun setUpViewHealth(data: List<Article>?) {

        healthNewsAdapter = HealthAdapter(
            healthdata = data ?: listOf(),
            context = binding.root.context,
            newsItemClickListener = this

        )
        binding.componentHealth.rvNewsList.adapter = healthNewsAdapter
    }

    override fun onNewsItemClickListener(url: String) {
        val intent = Intent(requireContext(),HealthActivity::class.java)
        intent.putExtra("url",url)
        startActivity(intent)
    }
}