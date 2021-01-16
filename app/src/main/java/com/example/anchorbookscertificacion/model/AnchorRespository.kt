package com.example.anchorbookscertificacion.model

import android.util.Log
import com.example.anchorbookscertificacion.model.api.RetrofitClient
import com.example.anchorbookscertificacion.model.pojos.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnchorRespository : IAnchorRepository {
    override fun loadData() {
        Log.d("AAA", "loadData")
        val retrofit = RetrofitClient.retrofitInstance()
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
}