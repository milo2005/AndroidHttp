package unicauca.movil.libros

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import unicauca.movil.libros.databinding.ActivityLoginBinding
import unicauca.movil.libros.models.User
import unicauca.movil.libros.util.text

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.handler = this
    }

    fun goToRegister() {
        startActivity<RegisterActivity>()
    }

    fun login() {
        val email = email.text()
        val pass = pass.text()
        val user = User(email, pass)
    }
}
