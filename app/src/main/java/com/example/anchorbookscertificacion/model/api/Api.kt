package com.example.anchorbookscertificacion.model.api

import com.example.anchorbookscertificacion.model.pojos.Book
import com.example.anchorbookscertificacion.model.pojos.BookDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("books")
    fun getBooks(): Call<List<Book>>

    @GET("bookDetail/{id}")
    fun getBookDetail(@Path("id") id: Int): Call<BookDetail>
}