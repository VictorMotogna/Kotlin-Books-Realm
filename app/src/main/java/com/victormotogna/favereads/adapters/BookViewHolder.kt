package com.victormotogna.favereads.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.victormotogna.favereads.R
import com.victormotogna.favereads.model.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.book_title
    val author: TextView = itemView.book_author
    val description: TextView = itemView.book_description
    val price: TextView = itemView.book_price
    val favorite: Button = itemView.btn_fave

    fun updateUi(book: Book, context: Context) {
        title.text = book.title
        description.text = book.description
        author.text = book.author
        price.text = book.price.toString()

        if (book.favorite == true) {
            favorite.background = context.getDrawable(R.drawable.star_fill)
        } else {
            favorite.background = context.getDrawable(R.drawable.star_stroke)
        }
    }
}