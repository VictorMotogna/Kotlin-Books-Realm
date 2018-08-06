package com.victormotogna.favereads.api

import com.victormotogna.favereads.model.Book
import retrofit2.Call
import retrofit2.http.GET

interface BooksApi {
    @GET("/booksapi/books")
    fun getBooks(): Call<List<Book>>
}