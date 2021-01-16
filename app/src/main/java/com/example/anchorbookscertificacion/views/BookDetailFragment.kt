package com.example.anchorbookscertificacion.views

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.anchorbookscertificacion.R
import com.example.anchorbookscertificacion.model.entities.BooksDetailEntity
import com.example.anchorbookscertificacion.viewmodel.AnchorBooksDetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_book_detail.view.*


class BookDetailFragment : Fragment() {

    private lateinit var booksDetailViewModel: AnchorBooksDetailViewModel
    private var bookId = 1
    private lateinit var root: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_book_detail, container, false)

        Log.d("AAA", "id $bookId")
        initObservers()
        return root
    }

    fun initObservers(){
        booksDetailViewModel = ViewModelProviders.of(this).get(AnchorBooksDetailViewModel::class.java)
        booksDetailViewModel.loadDetail(bookId)
        booksDetailViewModel.getBookDetail(bookId).observe(viewLifecycleOwner, Observer {
            Log.d("AAA", "getBookDetail $it")
            if (it.size>0){
                loadDetail(it.get(0))
            }else {
                Log.d("AAA", "lista de detalles $it")
            }
        })
    }

    fun loadDetail(bookDetail: BooksDetailEntity){
        root.tituloDetail.text = bookDetail.title
        root.subTituloDetail.text = bookDetail.author
        root.precioDetail.text = bookDetail.price.toString()
        root.shippingDetail.visibility = when{
            bookDetail.delivery -> View.VISIBLE
            else -> View.GONE
        }
        root.comprarDetail.setOnClickListener{
            Log.d("AAA", "Click comprar")
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ventas@anchorBooks.cl"))
            intent.putExtra(Intent.EXTRA_SUBJECT, " Consulta por libro ${bookDetail.title} id ${bookDetail.id}")
            intent.putExtra(Intent.EXTRA_TEXT, "“Hola\n" +
                    "Vi el libro ${bookDetail.title} de código ${bookDetail.id} y me gustaría que me contactaran a este correo o al\n" +
                    "siguiente número _________\n" +
                    "Quedo atento.”")

            startActivity(Intent.createChooser(intent, "Send Email"))
        }
        Picasso.get()
            .load(bookDetail.imageLink)
            .resize(250, 250)
            .centerCrop()
            .into(root.portadaDetail)
        root.paginasDetail.text = bookDetail.pages.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(bundle: Bundle) =
            BookDetailFragment().apply {
                arguments = Bundle().apply {
                    bookId = bundle.getInt("id")
                }
            }
    }
}