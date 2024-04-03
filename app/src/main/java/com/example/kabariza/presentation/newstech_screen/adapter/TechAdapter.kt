package com.example.kabariza.presentation.newstech_screen.adapter

import Article
import NewsResponse
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kabariza.R
import com.example.kabariza.data.remote.NewsRemoteDataSource
import com.example.kabariza.databinding.ItemNewsListBinding
import com.example.kabariza.presentation.newshealth_screen.adapter.HealthAdapter
import com.example.kabariza.utils.NewsItemClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TechAdapter(private val techdata: List<Article>,
                  private val context : Context,
                  private val newsItemClickListener: NewsItemClickListener
) : RecyclerView.Adapter<TechAdapter.techViewHolder> ()  {

    inner class techViewHolder(val binding: ItemNewsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Article) {
            binding.tvNewsTitle.text = data.title
            binding.tvNewsDescription.text = data.description

            Glide.with(context)
                .load(data.urlToImage)
                .centerCrop()
                .error(R.drawable.image_not_found_icon) // Error image if loading fails
                .placeholder(R.drawable.tube_spinner)
                .into(binding.ivCardNews)
            binding.root.setOnClickListener{
                newsItemClickListener.onNewsItemClickListener(data.url)
            }
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): techViewHolder {
        return techViewHolder(
            ItemNewsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount()= techdata.size


    override fun onBindViewHolder(holder: techViewHolder, position: Int) {
        holder.bind(techdata[position])    }
}




