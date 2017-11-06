package unicauca.movil.libros.models

/**
 * Created by darfe on 21/05/2017.
 */

class User {

    var idusuario: Long? = null
    lateinit  var nombre: String
    var email: String
    var password: String

    constructor(nombre: String, email: String, password: String) {
        this.nombre = nombre
        this.email = email
        this.password = password
    }

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }
}
