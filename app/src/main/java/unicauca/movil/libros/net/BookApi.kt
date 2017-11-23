package unicauca.movil.libros.net

import retrofit2.Call
import retrofit2.http.*
import unicauca.movil.libros.models.Book

/**
 * Created by darfe on 22/11/2017.
 */
interface BookApi{

    @GET("/libros")
    fun all():Call<List<Book>>

    @GET("/libros/{id}")
    fun getById(@Path("id") id:String):Call<Book>

    @POST("/libros")
    fun insert(@Body book:Book):Call<SimpleResponse>

}

data class SimpleResponse(val success:Boolean)