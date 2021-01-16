package com.example.anchorbookscertificacion.model.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import com.example.anchorbookscertificacion.model.pojos.BookDetail

@Dao
interface AnchorDao {
    //Inserta una lista de libros
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(libros: List<BooksEntity>)

    //Obtiene todos los valores de clima desde Room DB
    @Query("SELECT * FROM books")
    fun getAllBooks(): LiveData<List<BooksEntity>>

    //Inserta los valores de clima
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookDetail(bookDetail: BooksDetailEntity)

    //Obtiene todos los valores de tareas de un dia desde Room DB
    @Query("SELECT * FROM details WHERE id = :id")
    fun getBookDetail(id:Int): LiveData<List<BooksDetailEntity>>
}