package com.example.anchorbookscertificacion.model

import android.util.Log
import com.example.anchorbookscertificacion.model.api.RetrofitClient
import com.example.anchorbookscertificacion.model.pojos.Book
import com.example.anchorbookscertificacion.model.pojos.BookDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnchorRespository : IAnchorRepository {
    val retrofit = RetrofitClient.retrofitInstance()
    override fun loadData() {
        Log.d("AAA", "loadData")
        val call = retrofit.getBooks()
        call.enqueue(object : Callback<List<Book>> {
            override fun onResponse(
                call: retrofit2.Call<List<Book>>,
                response: Response<List<Book>>
            ) {
                Log.d("AAA", "response " + response)
                if (response.body() != null){
                    Log.d("AAA", "libros " + response.body())
                    //agendaManager.insertarClimas(repoUtil.mapperApiClima(response.body()!!))
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                Log.d("AAA", "onFailure " + t)
            }
        })
    }

    override fun loadDetalle(id: Int) {
        Log.d("AAA", "loadDetalle")
        val call = retrofit.getBookDetail(id)
        call.enqueue(object : Callback<BookDetail> {
            override fun onResponse(
                call: retrofit2.Call<BookDetail>,
                response: Response<BookDetail>
            ) {
                Log.d("AAA", "response " + response)
                if (response.body() != null){
                    Log.d("AAA", "libros " + response.body())
                    //agendaManager.insertarClimas(repoUtil.mapperApiClima(response.body()!!))
                }
            }

            override fun onFailure(call: Call<BookDetail>, t: Throwable) {
                Log.d("AAA", "onFailure " + t)
            }
        })
    }
}