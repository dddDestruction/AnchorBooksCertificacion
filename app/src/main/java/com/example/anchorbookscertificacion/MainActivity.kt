package com.example.anchorbookscertificacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.anchorbookscertificacion.model.AnchorRespository

class MainActivity : AppCompatActivity() {
    val repository = AnchorRespository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("AAA", "MainActivity")
        repository.loadData()
        repository.loadDetalle(1)
    }
}