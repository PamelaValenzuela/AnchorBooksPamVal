package com.example.anchorbooks.model.retrofit

import com.example.anchorbooks.model.dataClass.Books
import com.example.anchorbooks.model.dataClass.BooksDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {

    @GET("books")
    suspend fun getAllBooks(): Response<List<Books>>

   @GET("bookDetail/{id}")
    suspend fun getDetailCountryByName(@Path("id")id: Int): Response<BooksDetail>

}