package com.tryden.deltanews.newsfeed

import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tryden.deltanews.model.NewsFeedItem


// region RecyclerView
@BindingAdapter("setItems")
fun setItems(recyclerView: RecyclerView, list: List<NewsFeedItem>?) {
    (recyclerView.adapter as NewsFeedRecyclerViewAdapter).setItems(list)
}
// endregion RecyclerView

// region ImageView
@BindingAdapter("loadWithPicasso")
fun loadWithPicasso(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}
// endregion ImageView

// region WebView
@BindingAdapter("loadUrlIntoWebView")
fun loadUrlIntoWebView(webView: WebView, url: String) {
    webView.loadUrl(url)
}
// endregion WebView