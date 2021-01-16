package com.example.anchorbookscertificacion.model.db

import androidx.lifecycle.LiveData
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import kotlinx.coroutines.Job

interface IAnchorDBManager {
    fun insertBooks(books:List<BooksEntity>): Job
    fun getBooks(): LiveData<List<BooksEntity>>
    fun insertBookDetail(booksDetailEntity: BooksDetailEntity): Job
    fun getBookDetail(id:Int): LiveData<List<BooksDetailEntity>>
}