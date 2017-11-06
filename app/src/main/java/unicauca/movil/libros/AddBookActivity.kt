package unicauca.movil.libros

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_book.*

import unicauca.movil.libros.databinding.ActivityAddBookBinding
import unicauca.movil.libros.models.Book
import unicauca.movil.libros.util.text

class AddBookActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_book)
        binding.handler = this
    }

    fun addBook() {
        val name = nombre.text()
        val author = autor.text()
        val pags = pag.text()

        val book = Book(name, author, pags.toInt())
    }
}
