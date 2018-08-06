package com.victormotogna.favereads.model

import java.io.Serializable

class Book(
        val id: Int = 0,
        val title: String? = "",
        val author: String? = "",
        val description: String? = "",
        val price: Int? = 0,
        var favorite: Boolean? = false
) : Serializable