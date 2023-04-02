package com.tryden.deltanews.newsfeed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tryden.deltanews.R
import com.tryden.deltanews.databinding.ActivityNewsFeedBinding
import com.tryden.deltanews.model.NewsFeedItem

class NewsFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityNewsFeedBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_feed)

        val viewModel: NewsFeedViewModel = ViewModelProvider(this)[NewsFeedViewModel::class.java]

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val newsFeedAdapter = NewsFeedRecyclerViewAdapter()
        binding.recyclerView.adapter = newsFeedAdapter

        viewModel.fetchNewsFeed()
    }
}