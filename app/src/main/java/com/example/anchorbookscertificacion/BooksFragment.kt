package com.example.anchorbookscertificacion

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.anchorbookscertificacion.viewmodel.AnchorBooksViewModel

class BooksFragment : Fragment() {
    private lateinit var booksViewModel: AnchorBooksViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            /*
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

             */
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("AAA", "En Fragmento BooksFragment")
        val root = inflater.inflate(R.layout.fragment_books, container, false)
        booksViewModel = ViewModelProviders.of(this).get(AnchorBooksViewModel::class.java)
        booksViewModel.books.observe(viewLifecycleOwner, Observer {
            Log.d("AAA", "Carga desde DB $it")
        })
        booksViewModel.load()
        //booksViewModel.loadDetalle(1)
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) =
            BooksFragment().apply {
                arguments = Bundle().apply {
                    /*
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                     */
                }
            }
    }
}