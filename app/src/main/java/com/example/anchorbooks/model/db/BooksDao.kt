package com.example.anchorbooks.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anchorbooks.model.dataClass.Books
import com.example.anchorbooks.model.dataClass.BooksDetail

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(BooksList:List<Books>)

    @Query("SELECT * FROM books_table")
    fun getBooksList(): LiveData<List<Books>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooksDetail(booksDetail: BooksDetail)

    @Query("SELECT * FROM books_detail_table WHERE id=:idObtained")
    fun getBooksDetail(idObtained:Int):LiveData<BooksDetail>

}