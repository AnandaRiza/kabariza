package com.example.kabariza.presentation.newshealth_screen.adapter

import Article
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kabariza.R
import com.example.kabariza.databinding.ItemNewsListBinding
import com.example.kabariza.utils.NewsItemClickListener

class HealthAdapter(private val healthdata: List<Article>,
                    private val context : Context,
                    private val newsItemClickListener: NewsItemClickListener) :
    RecyclerView.Adapter<HealthAdapter.healthViewHolder> () {

    inner class healthViewHolder(val binding: ItemNewsListBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): healthViewHolder {
        return healthViewHolder(
            ItemNewsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount()=healthdata.size
    override fun onBindViewHolder(holder: healthViewHolder, position: Int) {
        holder.bind(healthdata[position])
    }



}