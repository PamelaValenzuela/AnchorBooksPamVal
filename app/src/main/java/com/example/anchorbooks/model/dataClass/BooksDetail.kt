package com.example.anchorbooks.model.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_detail_table")

data class BooksDetail(
    @PrimaryKey val id: Int?,
    val author : String?,
    val country: String?,
    val imageLink:String?,
    val language: String?,
    val link: String?,
    val pages: String?,
    val title: String?,
    val year: Int?,
    val price: Int?,
    val lastPrice: Int?,
    val delivery: Boolean?

) {
}