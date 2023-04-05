package com.tryden.deltanews.newsfeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tryden.deltanews.model.NewsFeedItem

class NewsFeedViewModel : ViewModel() {

    private val repository = NewsRepository()

    private val _newsFeedLiveData = MutableLiveData<List<NewsFeedItem>>()
    val newsFeedLiveData: LiveData<List<NewsFeedItem>> = _newsFeedLiveData

    fun fetchNewsFeed() {
        repository.fetchNewsFeed(_newsFeedLiveData)
    }

    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
        repository.updateFavoriteStatus(id, isFavorite)
    }
}