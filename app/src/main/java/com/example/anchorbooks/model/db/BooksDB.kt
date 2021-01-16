package com.example.anchorbooks.model.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.anchorbooks.model.dataClass.Books
import com.example.anchorbooks.model.dataClass.BooksDetail


@Database(entities = [Books::class, BooksDetail::class],version = 1)
abstract class BooksDB: RoomDatabase(), BooksDao {

    abstract fun daoBooks():BooksDao


    companion object{
        @Volatile
        private var INSTANCE: BooksDao?=null

        fun getBooksDB(context : Context):BooksDao{
            val createdInstance = INSTANCE
            if(createdInstance!=null){
                return createdInstance
            }
            synchronized(this){
                val newInstance = Room.databaseBuilder(context.applicationContext,BooksDB::class.java,"Books_db")
                    .build()
                INSTANCE=newInstance
                return newInstance
            }
        }
    }

    /*override suspend fun insertBooks(BooksList: List<Books>) {
        TODO("Not yet implemented")
    }

    override fun getBooksList(): LiveData<List<Books>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBooksDetail(booksDetail: BooksDetail) {
        TODO("Not yet implemented")
    }

    override fun getBooksDetail(idObtained: Int): LiveData<BooksDetail> {
        TODO("Not yet implemented")
    }*/
}