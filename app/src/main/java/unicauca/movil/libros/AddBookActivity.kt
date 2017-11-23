package unicauca.movil.libros

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_book.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import unicauca.movil.libros.databinding.ActivityAddBookBinding
import unicauca.movil.libros.models.Book
import unicauca.movil.libros.net.AppClient
import unicauca.movil.libros.net.SimpleResponse
import unicauca.movil.libros.util.text

class AddBookActivity : AppCompatActivity(), Callback<SimpleResponse> {

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
        AppClient.bookApi.insert(book).enqueue(this)
    }

    override fun onResponse(call: Call<SimpleResponse>?, response: Response<SimpleResponse>?) {
        toast("Libro agregado !")
        finish()
    }

    override fun onFailure(call: Call<SimpleResponse>?, t: Throwable?) {
        toast("Error al agregar el libro")
    }
}
