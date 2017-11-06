package unicauca.movil.libros.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import unicauca.movil.libros.R
import unicauca.movil.libros.databinding.TemplateBookBinding
import unicauca.movil.libros.models.Book
import unicauca.movil.libros.util.inflate

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookHolder>() {

    var data: List<Book> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder
            = BookHolder(parent.inflate(R.layout.template_book))

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        holder.binding.book = data[position]
    }

    override fun getItemCount(): Int = data.size

    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: TemplateBookBinding = DataBindingUtil.bind(itemView)
    }
}
