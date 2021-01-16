package com.example.anchorbookscertificacion.model

interface IAnchorRepository {
    fun loadData()
    fun loadDetalle(id: Int)
}