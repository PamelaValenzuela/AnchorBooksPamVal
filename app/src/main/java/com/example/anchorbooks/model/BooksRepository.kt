package com.example.anchorbooks.model

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.anchorbooks.model.dataClass.Books
import com.example.anchorbooks.model.retrofit.RetrofitClient

class BooksRepository {

    val mBooksList : MutableLiveData<List<Books>> = MutableLiveData()

    suspend fun getBooksAll() {
        val mResponse= RetrofitClient.retrofitInstance().getAllBooks()

        if (mResponse.isSuccessful){
            mResponse.body()?.let {
                //una vez que se obtengan los valores, estos se guardaran en nuestra variable 11 y con livedata se estará observando
                mBooksList.value=it
                Log.d("Response true","${it.size}")
            }

        }
        else{
            Log.d("Pamela","${mResponse.errorBody()}")
        }
    }
}