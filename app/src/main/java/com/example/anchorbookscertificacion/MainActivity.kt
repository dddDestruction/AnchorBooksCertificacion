package com.example.anchorbookscertificacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.anchorbookscertificacion.views.BooksFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = BooksFragment.newInstance(Bundle())
        selectFragment(fragment)
    }

    fun selectFragment(fragment: Fragment){
        val manager = supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}