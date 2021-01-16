package com.example.anchorbookscertificacion.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BooksEntity(
    @PrimaryKey var id: Int,
    var author: String,
    var country: String,
    var imageLink: String,
    var language: String,
    var title: String
)

@Entity(tableName = "details")
data class BooksDetailEntity(
    @PrimaryKey var id: Int,
    var author: String,
    var country: String,
    var imageLink: String,
    var language: String,
    var link: String,
    var pages: Int,
    var title: String,
    var year: Int,
    var price: Int,
    var lastPrice: Int,
    var delivery: Boolean
)
