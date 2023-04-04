package com.tryden.deltanews.newsfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.tryden.deltanews.DetailActivity
import com.tryden.deltanews.R
import com.tryden.deltanews.databinding.ActivityNewsFeedBinding
import com.tryden.deltanews.model.NewsFeedItem
import java.lang.ref.WeakReference

class NewsFeedActivity : AppCompatActivity(), NewsFeedRecyclerViewAdapter.NewsFeedItemInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityNewsFeedBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_news_feed)

        val viewModel: NewsFeedViewModel = ViewModelProvider(this)[NewsFeedViewModel::class.java]

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val newsFeedAdapter = NewsFeedRecyclerViewAdapter(WeakReference(this))
        binding.recyclerView.adapter = newsFeedAdapter

        viewModel.fetchNewsFeed()
    }

    override fun onNewsFeedItemClicked(url: String) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.ARG_URL, url)
        }
        startActivity(intent)
    }
}