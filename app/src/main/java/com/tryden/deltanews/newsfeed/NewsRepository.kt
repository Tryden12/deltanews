package com.tryden.deltanews.newsfeed

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.tryden.deltanews.model.NewsFeedItem

class NewsRepository {

    private val database = Firebase.database
    private val newsFeedReference = database.getReference("news_feed")

    fun fetchNewsFeed(liveData: MutableLiveData<List<NewsFeedItem>>) {
        newsFeedReference
            .orderByChild("_rank")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val newsFeedItems: List<NewsFeedItem> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(NewsFeedItem::class.java)!!.copy(id = dataSnapshot.key!!)
                    }
                    liveData.postValue(newsFeedItems)
                }

                override fun onCancelled(error: DatabaseError) {
                    // nothing to do
                }
            })
    }

    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
        newsFeedReference.child(id).child("favorite").setValue(isFavorite)
    }
}