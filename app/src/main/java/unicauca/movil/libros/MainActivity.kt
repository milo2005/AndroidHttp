package unicauca.movil.libros

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import unicauca.movil.libros.adapters.BookAdapter
import unicauca.movil.libros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

    }

    fun goToAdd() {
        startActivity<AddBookActivity>()
    }
}
