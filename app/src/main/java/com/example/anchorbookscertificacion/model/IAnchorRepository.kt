package com.example.anchorbookscertificacion.model

import androidx.lifecycle.LiveData
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity

interface IAnchorRepository {
    fun loadData()
    fun loadDetalle(id: Int)
    fun getBookDetailInDB(id: Int): LiveData<List<BooksDetailEntity>>
}