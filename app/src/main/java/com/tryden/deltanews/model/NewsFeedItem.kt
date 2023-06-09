package com.tryden.deltanews.model

data class NewsFeedItem(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val url: String = "",
    val published: String = "",
    val source: String = "",
    val favorite: Boolean = false
)