package com.example.anchorbookscertificacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.anchorbookscertificacion.views.BooksFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("AAA", "MainActivity")
        val fragment = BooksFragment.newInstance(Bundle())
        val manager = supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}