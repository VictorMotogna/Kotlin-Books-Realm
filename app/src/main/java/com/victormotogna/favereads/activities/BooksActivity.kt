package com.victormotogna.favereads.activities

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.mcxiaoke.koi.ext.onClick
import com.victormotogna.favereads.R
import com.victormotogna.favereads.adapters.BooksAdapter
import com.victormotogna.favereads.dal.local.RealmManager
import com.victormotogna.favereads.model.Book
import com.victormotogna.favereads.viewmodels.BooksViewModel
import kotlinx.android.synthetic.main.activity_books.*
import org.koin.android.ext.android.inject

class BooksActivity : AppCompatActivity() {

    private val viewModel by inject<BooksViewModel>()
    private val realmManager by inject<RealmManager>()
    private val adapter by lazy { BooksAdapter(this, listOf(), realmManager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setupRecyclerView()
        viewModel.fetchData()
        observeData()

        view_favorites.onClick { faveBooks() }
    }

    private fun setupRecyclerView() {
        rv_all_books.setHasFixedSize(true)
        rv_all_books.layoutManager = LinearLayoutManager(this)
        rv_all_books.adapter = adapter

        refresh_books.setOnRefreshListener { viewModel.fetchData() }
    }

    private fun observeData() {
        viewModel.booksList.observe(this, Observer<List<Book>> { listOfBooks ->
            adapter.updateList(listOfBooks ?: listOf())
            refresh_books.isRefreshing = false
        })
    }

    private fun faveBooks() {
        adapter.updateList(realmManager.getAll())
    }
}