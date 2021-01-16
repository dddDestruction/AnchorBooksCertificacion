package com.example.anchorbookscertificacion.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anchorbookscertificacion.model.AnchorRespository

class AnchorBooksViewModel(application: Application) : AndroidViewModel(application) {

    val repository = AnchorRespository(application, viewModelScope)
    val books = repository.books

    fun load(){
        repository.loadData()
    }
}