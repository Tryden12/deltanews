package com.tryden.deltanews.newsfeed

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tryden.deltanews.model.NewsFeedItem


// region RecyclerView
@BindingAdapter("setItems")
fun setItems(recyclerView: RecyclerView, list: List<NewsFeedItem>?) {
    (recyclerView.adapter as NewsFeedRecyclerViewAdapter).setItems(list)
}
// endregion RecyclerView