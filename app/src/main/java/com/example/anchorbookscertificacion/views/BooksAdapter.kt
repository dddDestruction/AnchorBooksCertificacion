package com.example.anchorbookscertificacion.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.anchorbookscertificacion.R
import com.example.anchorbookscertificacion.model.entities.BooksEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book_layout.view.*

class BooksAdapter(private var lista: List<BooksEntity>) : RecyclerView.Adapter<BooksAdapter.BookHolder>() {

    val selectedItem = MutableLiveData<BooksEntity>()

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo = itemView.titulo
        val subTitulo = itemView.subTitulo
        val portada = itemView.portada
        val cardView = itemView.cardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book_layout, parent, false)
        return BookHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val book = lista.get(position)
        with(holder){
            titulo.text = book.title
            subTitulo.text = book.author
        }
        Picasso.get()
            .load(book.imageLink)
            .resize(250, 250)
            .centerCrop()
            .into(holder.portada)
        holder.cardView.setOnClickListener{
            selectedItem.value = book
        }
    }

    fun update(list:List<BooksEntity>){
        lista = list
        notifyDataSetChanged()
    }
}