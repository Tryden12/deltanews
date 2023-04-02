package com.tryden.deltanews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsFeedViewModel : ViewModel() {

    val repository = NewsRepository()

    private val _newsFeedLiveData = MutableLiveData<List<NewsFeedItem>>()
    val newsFeedLiveData: LiveData<List<NewsFeedItem>> = _newsFeedLiveData

    fun fetchNewsFeed() {
        repository.fetchNewsFeed(_newsFeedLiveData)
    }

}