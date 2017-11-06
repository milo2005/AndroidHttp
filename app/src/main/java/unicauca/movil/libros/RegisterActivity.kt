package unicauca.movil.libros

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

import unicauca.movil.libros.databinding.ActivityRegisterBinding
import unicauca.movil.libros.models.User
import unicauca.movil.libros.util.text

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        binding.handler = this
    }

    fun register() {
        val email = email.text()
        val pass = pass.text()
        val name = nombre.text()
        val user = User(name, email, pass)
    }
}
