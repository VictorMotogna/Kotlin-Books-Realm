package com.victormotogna.favereads.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Book : RealmObject() {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    open var id: Long = 0

    @SerializedName("title")
    @Expose
    open var title: String? = ""

    @SerializedName("author")
    @Expose
    open var author: String? = ""

    @SerializedName("description")
    @Expose
    open var description: String? = ""

    @SerializedName("price")
    @Expose
    open var price: Int? = 0

    @SerializedName("favorite")
    @Expose
    open var favorite: Boolean? = false
}