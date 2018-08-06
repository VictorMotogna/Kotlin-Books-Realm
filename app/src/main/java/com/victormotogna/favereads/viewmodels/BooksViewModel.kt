package com.victormotogna.favereads.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.victormotogna.favereads.dal.api.BooksApi
import com.victormotogna.favereads.model.Book
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BooksViewModel : ViewModel(), KoinComponent {
    private val jsonApi by inject<BooksApi>()
    val booksList: MutableLiveData<List<Book>> = MutableLiveData()

    fun fetchData() {
        jsonApi.getBooks().enqueue(object : Callback<List<Book>> {
            override fun onFailure(call: Call<List<Book>>?, t: Throwable?) {
                Log.e("BooksViewModel", "Request get books failure")
            }

            override fun onResponse(call: Call<List<Book>>?, response: Response<List<Book>>?) {
                booksList.value = response?.body() ?: return
            }
        })
    }
}