package com.example.anchorbookscertificacion.model

import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import com.example.anchorbookscertificacion.model.pojos.Book
import com.example.anchorbookscertificacion.model.pojos.BookDetail

interface IPojoToEntityMapper {
    fun booksToEntityMapper(books:List<Book>): List<BooksEntity>
    fun booksDetailToEntityMapper(bookDetail: BookDetail): BooksDetailEntity
}