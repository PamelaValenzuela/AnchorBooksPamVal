package com.example.anchorbooks.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anchorbooks.model.BooksRepository
import com.example.anchorbooks.model.dataClass.Books
import kotlinx.coroutines.launch

class BooksViewModel : ViewModel(){

    private val repositoryvm= BooksRepository()

    private val books= repositoryvm.mBooksList

    init{
        Log.d("initviewmodel","funciona")
        viewModelScope.launch {
            repositoryvm.getBooksAll()
        }
    }
    fun doSomething(){

    }

    fun booksList(): LiveData<List<Books>> = books
   /* private fun insertWebDataIntoDB(){
        repositoryP.insertWebDataIntoDB()
    }
    init {
        insertWebDataIntoDB()
    }

    fun getPhoneList(): LiveData<List<PhoneP>> {
        return repositoryP.getPhoneList()
    }

    fun insertWebDetailDataIntoDB(id:Int){
        repositoryP.insertWebDetailDataIntoDB(id)
    }

    fun getPhoneDetail(id:Int): LiveData<PhoneDetail> {
        return repositoryP.getPhoneDetail(id)
    }*/

}