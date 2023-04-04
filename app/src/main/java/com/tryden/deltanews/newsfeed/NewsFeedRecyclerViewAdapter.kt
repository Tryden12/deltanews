package com.tryden.deltanews.newsfeed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tryden.deltanews.R
import com.tryden.deltanews.databinding.ViewHolderNewsFeedItemBinding
import com.tryden.deltanews.model.NewsFeedItem
import java.lang.ref.WeakReference

class NewsFeedRecyclerViewAdapter(
    private val callbackWeakRef: WeakReference<NewsFeedItemInterface>
): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface NewsFeedItemInterface {
        fun onNewsFeedItemClicked(url: String)
    }

    private val newsFeedItems = mutableListOf<NewsFeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewItemHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsViewItemHolder).onBind(newsFeedItems[position]) { url ->
            callbackWeakRef.get()?.onNewsFeedItemClicked(url)
        }
    }

    override fun getItemCount(): Int {
        return newsFeedItems.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newsFeedItems: List<NewsFeedItem>?) {
        this.newsFeedItems.clear()
        this.newsFeedItems.addAll(newsFeedItems ?: emptyList())
        notifyDataSetChanged()
    }

    inner class NewsViewItemHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_news_feed_item, parent, false)
    ) {

        private val binding = ViewHolderNewsFeedItemBinding.bind(itemView)
        fun onBind(newsFeedItem: NewsFeedItem, onClick: (String) -> Unit) {
            binding.title = newsFeedItem.title
            binding.description = newsFeedItem.description
            binding.source = newsFeedItem.source
            binding.published = newsFeedItem.published
            binding.imageUrl = newsFeedItem.imageUrl
            binding.root.setOnClickListener {
                onClick(newsFeedItem.url)
            }
        }
    }
}