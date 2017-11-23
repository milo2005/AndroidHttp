package unicauca.movil.libros

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import unicauca.movil.libros.adapters.BookAdapter
import unicauca.movil.libros.databinding.ActivityMainBinding
import unicauca.movil.libros.models.Book
import unicauca.movil.libros.net.AppClient

class MainActivity : AppCompatActivity(), Callback<List<Book>> {


    lateinit var binding: ActivityMainBinding
    private val adapter: BookAdapter = BookAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handler = this

        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
        loadBooks()
    }

    private fun loadBooks() {
        AppClient.bookApi.all().enqueue(this)
    }

    fun goToAdd() {
        startActivity<AddBookActivity>()
    }

    override fun onFailure(call: Call<List<Book>>?, t: Throwable?) {
        toast("Error al consultar libros")
    }

    override fun onResponse(call: Call<List<Book>>?, response: Response<List<Book>>) {
        if(response.isSuccessful){
            adapter.data = response.body()!!
        }
    }
}
