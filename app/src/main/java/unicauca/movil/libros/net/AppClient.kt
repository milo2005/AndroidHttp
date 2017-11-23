package unicauca.movil.libros.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by darfe on 22/11/2017.
 */
object AppClient{

    private val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")//Si es con emulador
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val bookApi:BookApi = retrofit.create(BookApi::class.java)

}