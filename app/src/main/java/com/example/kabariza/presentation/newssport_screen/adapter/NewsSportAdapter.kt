package com.example.kabariza.presentation.newssport_screen.adapter

import Article
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.example.kabariza.R
import com.example.kabariza.databinding.FragmentSportBinding
import com.example.kabariza.databinding.ItemNewsListBinding
import com.example.kabariza.utils.NewsItemClickListener


class NewsSportAdapter(private val sportdata: List<Article>, private val context: Context, private val newsItemClickListener: NewsItemClickListener) :
    RecyclerView.Adapter<NewsSportAdapter.sportViewHolder>() {

    inner class sportViewHolder(val binding: ItemNewsListBinding):
    RecyclerView.ViewHolder(binding.root){

        fun bind(data: Article) {
            binding.tvNewsTitle.text = data.title
            binding.tvNewsDescription.text = data.description

            Glide.with(context)
                .load(data.urlToImage)
                .centerCrop()
                .error(R.drawable.ic_launcher_background) // Error image if loading fails
                .into(binding.ivCardNews)
            binding.root.setOnClickListener {
                newsItemClickListener.onNewsItemClickListener(data.url)
            }
        }

    }

//    private val fragmentContent = arrayListOf<Fragment>()
//
//    fun addListFragment(fragment: Fragment){
//        fragmentContent.add(fragment)
//    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsSportAdapter.sportViewHolder {
        return sportViewHolder(
            ItemNewsListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )    }

    override fun onBindViewHolder(holder: NewsSportAdapter.sportViewHolder, position: Int) {
        holder.bind(sportdata[position])
    }

    override fun getItemCount() = sportdata.size



}