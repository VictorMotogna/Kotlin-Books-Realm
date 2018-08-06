package com.victormotogna.favereads.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.victormotogna.favereads.R
import com.victormotogna.favereads.model.Book

class BooksAdapter(private var context: Context,
                   private var booksList: List<Book>) : RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_book, parent, false)

        return BookViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return booksList.size
    }

    fun updateList(newList: List<Book>) {
        this.booksList = newList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.updateUi(booksList[position], context)

        holder.favorite.setOnClickListener {
            booksList[position].favorite = not(booksList[position].favorite)
            holder.updateUi(booksList[position], context)
        }
    }

    fun not(value: Boolean?): Boolean {
        return value != true
    }
}