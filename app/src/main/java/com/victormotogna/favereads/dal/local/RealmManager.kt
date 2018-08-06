package com.victormotogna.favereads.dal.local

import com.victormotogna.favereads.model.Book
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmManager {

    val realm: Realm by lazy {
        val config = RealmConfiguration.Builder()
                .name("favebooks.realm")
                .schemaVersion(3)
                .build()

        Realm.getInstance(config)
    }

    fun find(id: Long): Book? {
        return realm.where(Book::class.java).equalTo("id", id).findFirst()
    }

    fun getAll(): List<Book> {
        return realm.where(Book::class.java).findAll()
    }

    fun insert(title: String, author: String, description: String, price: Int, favorite: Boolean) {
        realm.beginTransaction()
        var newId: Long = 1
        if (realm.where(Book::class.java).max("id") != null) {
            newId = realm.where(Book::class.java).max("id") as Long + 1
        }
        val book = realm.createObject(Book::class.java, newId)
        book.title = title
        book.author = author
        book.description = description
        book.price = price
        book.favorite = favorite
        realm.commitTransaction()
    }

    fun update(id: Long, title: String, author: String, description: String, price: Int, favorite: Boolean) {
        realm.beginTransaction()
        val book = find(id)
        book?.title = title
        book?.author = author
        book?.description = description
        book?.price = price
        book?.favorite = favorite
        realm.commitTransaction()
    }

    fun delete(id: Long) {
        realm.beginTransaction()
        val results = realm.where(Book::class.java).equalTo("id", id).findAll()
        results.deleteAllFromRealm()
        realm.commitTransaction()
    }
}