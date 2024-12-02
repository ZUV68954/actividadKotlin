import kotlin.system.exitProcess

var agenda: Agenda? = null
fun main() {
    crearAgenda()
}

fun crearAgenda() {
    println("Indica el tamaño de la agenda:")
    val respuesta = readln()
    if (respuesta=="0"){
        println("El tamaño de la agenda no puede ser de cero.")
        crearAgenda()
    }
    if (respuesta == "") {
        agenda = Agenda()
        menú()
    }
    try {
        val tamaño: Int = respuesta.toInt()
        agenda = Agenda(tamaño)
    } catch (e: NumberFormatException) {
        println("La entrada introducida no es un número.")
        crearAgenda()
    }
    menú()
}

fun menú() {
    println("1.- Añadir contacto")
    println("2.- Listar contactos")
    println("3.- Buscar contactos")
    println("4.- Comprobar si ya existe el contacto")
    println("5.- Eliminar contacto")
    println("6.- Huecos disponibles")
    println("7.- Agenda llena")
    println("8.- Salir")
    var opción: Int? = null
    try {
        opción = readln().toInt()
    } catch (e: NumberFormatException) {
        println("La entrada introducida no es un número.")
        menú()
    }
    if (opción == 1) {
        if (agenda?.añadirContacto(crearContacto()) == true) {
            println("Se ha añadido el contacto correctamente.")
            menú()
        } else {
            println("No se ha podido crear el contacto.")
            menú()
        }
    } else if (opción == 2) {
        agenda?.listarContactos()
        menú()
    } else if (opción == 3) {
        println("Introduce el nombre del contacto a buscar.")
        val contacto = agenda?.comprobarExistencia(Contacto(readln(), "123456789"))
        if (contacto != null) {
            println("Se ha encontrado el contacto, su teléfono es $contacto.")
            menú()
        } else {
            println("No se ha encontrado el contacto solicitado.")
            menú()
        }
    } else if (opción == 4) {
        println("Introduce el nombre del contacto a buscar.")
        val contacto = agenda?.comprobarExistencia(Contacto(readln(), "123456789"))
        if (contacto != null) {
            println("El contacto ya existe.")
            menú()
        } else {
            println("El contacto no existe.")
            menú()
        }
    } else if (opción == 5) {
        println("Introduce el nombre del contacto a eliminar.")
        if (agenda?.eliminarContacto(readln()) == true) {
            println("Se ha eliminado el contacto.")
            menú()
        } else {
            println("No se ha eliminado el contacto.")
            menú()
        }
    } else if (opción == 6) {
        val huecos = agenda?.huecosLibres()
        if (huecos == 0) {
            println("No quedan huecos libres.")
            menú()
        } else if (huecos == 1) {
            println("Queda un hueco libre.")
            menú()
        } else {
            println("Quedan $huecos libres.")
            menú()
        }
    } else if (opción == 7) {
        if (agenda?.huecosLibres() == 0) {
            println("No quedan huecos libres en la agenda.")
            menú()
        } else {
            println("Aún quedan huecos libres en la agenda.")
            menú()
        }
    } else if (opción == 8) {
        println("Saliendo del programa.")
        exitProcess(0)
    } else {
        println("El valor introducido no es valido.")
        menú()
    }
}

fun crearContacto(): Contacto {
    println("Introduce el nombre del contacto:")
    val nombre = readln()
    var datosCorrectos = false
    var teléfono: String = ""
    while (!datosCorrectos) {
        println("Introduce el teléfono del contacto:")
        teléfono = readln()
        try {
            teléfono.toLong()
            if (teléfono.length != 9) {
                println("La longitud del teléfono no es correcta")
                datosCorrectos = false
            } else {
                datosCorrectos = true
            }
        } catch (e: NumberFormatException) {
            println("No se ha introducido un número.")
            datosCorrectos = false
        }
    }
    return Contacto(nombre, teléfono)
}