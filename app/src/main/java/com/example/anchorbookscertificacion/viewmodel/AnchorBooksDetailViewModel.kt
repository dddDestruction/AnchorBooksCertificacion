package com.example.anchorbookscertificacion.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.anchorbookscertificacion.model.AnchorRespository
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity

class AnchorBooksDetailViewModel(application: Application) : AndroidViewModel(application) {

    val repository = AnchorRespository(application, viewModelScope)

    fun loadDetail(id: Int){
        repository.loadDetalle(id)
    }

    fun getBookDetail(id: Int): LiveData<List<BooksDetailEntity>> {
        return repository.getBookDetailInDB(id)
    }

}