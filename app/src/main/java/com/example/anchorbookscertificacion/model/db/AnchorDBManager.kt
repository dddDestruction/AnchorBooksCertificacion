package com.example.anchorbookscertificacion.model.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AnchorDBManager(val context: Context, val scope: CoroutineScope): IAnchorDBManager {

    val anchorDao = AnchorDB.getDatabase(context).dao()

    override fun insertBooks(books: List<BooksEntity>) = scope.launch {
        anchorDao.insertBooks(books)
    }

    override fun getBooks(): LiveData<List<BooksEntity>> {
        return anchorDao.getAllBooks()
    }

    override fun insertBookDetail(booksDetailEntity: BooksDetailEntity) = scope.launch  {
        anchorDao.insertBookDetail(booksDetailEntity)
    }

    override fun getBookDetail(id: Int): LiveData<List<BooksDetailEntity>> {
        return anchorDao.getBookDetail(id)
    }
}