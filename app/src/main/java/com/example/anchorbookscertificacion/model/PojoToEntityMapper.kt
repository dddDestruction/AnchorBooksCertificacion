package com.example.anchorbookscertificacion.model

import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import com.example.anchorbookscertificacion.model.pojos.Book
import com.example.anchorbookscertificacion.model.pojos.BookDetail

class PojoToEntityMapper: IPojoToEntityMapper {
    override fun booksToEntityMapper(books: List<Book>): List<BooksEntity> {
        var lista = mutableListOf<BooksEntity>()
        for (book in books){
            var bookEntity = BooksEntity(
                book.id,
                book.author,
                book.country,
                book.imageLink,
                book.language,
                book.title
            )
            lista.add(bookEntity)
        }
        return lista
    }

    override fun booksDetailToEntityMapper(bookDetail: BookDetail): BooksDetailEntity {
        return BooksDetailEntity(
            bookDetail.id,
            bookDetail.author,
            bookDetail.country,
            bookDetail.imageLink,
            bookDetail.language,
            bookDetail.link,
            bookDetail.pages,
            bookDetail.title,
            bookDetail.year,
            bookDetail.price,
            bookDetail.lastPrice,
            bookDetail.delivery
        )
    }
}