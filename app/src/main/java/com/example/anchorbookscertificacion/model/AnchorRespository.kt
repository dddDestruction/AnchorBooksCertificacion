package com.example.anchorbookscertificacion.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.anchorbookscertificacion.model.api.RetrofitClient
import com.example.anchorbookscertificacion.model.db.AnchorDBManager
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.model.pojos.Book
import com.example.anchorbookscertificacion.model.pojos.BookDetail
import kotlinx.coroutines.CoroutineScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnchorRespository(context: Context, scope: CoroutineScope) : IAnchorRepository {

    val retrofit = RetrofitClient.retrofitInstance()
    val anchorManager = AnchorDBManager(context, scope)
    var books = anchorManager.getBooks()
    val mapper = PojoToEntityMapper()

    override fun loadData() {
        val call = retrofit.getBooks()
        call.enqueue(object : Callback<List<Book>> {
            override fun onResponse(
                call: retrofit2.Call<List<Book>>,
                response: Response<List<Book>>
            ) {
                if (response.body() != null){
                    anchorManager.insertBooks(mapper.booksToEntityMapper(response.body()!!))
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
            }
        })
    }

    override fun loadDetalle(id: Int) {
        val call = retrofit.getBookDetail(id)
        call.enqueue(object : Callback<BookDetail> {
            override fun onResponse(
                call: retrofit2.Call<BookDetail>,
                response: Response<BookDetail>
            ) {
                if (response.body() != null){
                    anchorManager.insertBookDetail(mapper.booksDetailToEntityMapper(response.body()!!))
                }
            }

            override fun onFailure(call: Call<BookDetail>, t: Throwable) {

            }
        })
    }

    override fun getBookDetailInDB(id: Int): LiveData<List<BooksDetailEntity>> {
        return anchorManager.getBookDetail(id)
    }
}