package com.example.kabariza.presentation.newstech_screen.view

import Article
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.kabariza.base.BaseFragment
import com.example.kabariza.databinding.FragmentTechBinding
import com.example.kabariza.presentation.newstech_screen.adapter.TechAdapter
import com.example.kabariza.presentation.newstech_screen.view_model.NewsTechViewModel
import com.example.kabariza.utils.NewsItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechFragment : BaseFragment<FragmentTechBinding>(), NewsItemClickListener {
    private lateinit var techNewsAdapter: TechAdapter
    private val viewmodel : NewsTechViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTechBinding {
        return FragmentTechBinding.inflate(inflater,container,false)
    }

    override fun setupView() {
        viewmodel.getTechNews()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewmodel.homeTechNews.observe(viewLifecycleOwner){
            setUpViewTech(it.articles)
        }
    }

    private fun setUpViewTech(data:List<Article>?){

        techNewsAdapter = TechAdapter(
            techdata = data ?: listOf(),
            context = binding.root.context,
            newsItemClickListener = this
        )
        binding.componentTech.rvNewsList.adapter=techNewsAdapter
    }

    override fun onNewsItemClickListener(url: String) {
        val intent = Intent(requireContext(), TechActivity::class.java)
        intent.putExtra("url",url)
        startActivity(intent)    }
}