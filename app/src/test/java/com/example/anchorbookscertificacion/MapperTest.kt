package com.example.anchorbookscertificacion

import com.example.anchorbookscertificacion.model.PojoToEntityMapper
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import com.example.anchorbookscertificacion.model.pojos.Book
import org.junit.Assert
import org.junit.Test

class MapperTest {
    val mapper = PojoToEntityMapper()
    @Test
    fun booksToEntityMapper_HappyCase() {
        val libro = Book(
            1,
            "yo",
            "Chile",
            "Imagen",
            "sunny",
            "sunny"
        )
        val listaLibros = listOf<Book>(libro)
        val libroEntidad = BooksEntity(
            1,
            "yo",
            "Chile",
            "Imagen",
            "sunny",
            "sunny"
        )
        val listaLibrosEntidad = listOf<BooksEntity>(libroEntidad)
        Assert.assertEquals(listaLibrosEntidad, mapper.booksToEntityMapper(listaLibros))
    }
}