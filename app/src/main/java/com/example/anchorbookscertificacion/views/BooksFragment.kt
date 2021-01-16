package com.example.anchorbookscertificacion.views

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anchorbookscertificacion.MainActivity
import com.example.anchorbookscertificacion.R
import com.example.anchorbookscertificacion.viewmodel.AnchorBooksViewModel
import kotlinx.android.synthetic.main.fragment_books.view.*

class BooksFragment : Fragment() {

    private lateinit var booksViewModel: AnchorBooksViewModel
    val adapter = BooksAdapter(mutableListOf())

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
        initObserver()
        initRecycler(root)
        return root
    }

    fun initObserver(){
        booksViewModel = ViewModelProviders.of(this).get(AnchorBooksViewModel::class.java)
        booksViewModel.load()
        booksViewModel.books.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }

    fun initRecycler(root:View){
        val recyclerView = root.recyclerViewBooks
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter.selectedItem.observe(this, Observer {
            Log.d("AAA", "Click en $it")
            val bundle = Bundle()
            bundle.putInt("id", it.id )
            (activity as MainActivity).selectFragment(BookDetailFragment.newInstance(bundle))
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) =
            BooksFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}