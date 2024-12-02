class Agenda {
    private var contactos: ArrayList<Contacto>
    private var contador: Int = 0
    private var capacidad: Int

    constructor() {
        contactos = ArrayList(10)
        capacidad = 10
    }

    constructor(cantidad: Int) {
        contactos = ArrayList(cantidad)
        capacidad = cantidad
    }

    fun añadirContacto(contacto: Contacto): Boolean {
        if (contactos.contains(contacto)) {
            println("El contacto ya existe.")
            return false
        } else if (capacidad == contador) {
            println("No hay espacio para más contactos.")
            return false
        }
        contactos.add(contacto)
        contador++
        println("El contacto se ha añadido correctamente.")
        return true
    }

    fun huecosLibres(): Int {
        return capacidad - contador
    }

    fun eliminarContacto(nombre: String): Boolean {
        contactos.forEach { contacto ->
            if (contacto.nombre == nombre) {
                contador--
                return contactos.remove(contacto)
            }
        }
        return false
    }

    fun comprobarExistencia(contactoABuscar: Contacto): String? {
        contactos.forEach { contacto ->
            if (contacto.nombre == contactoABuscar.nombre) {
                return contacto.teléfono
            }
        }
        return null
    }

    fun listarContactos() {
        if (contador == 0) {
            println("No hay contactos en la agenda.")
        }
        contactos.forEach { contacto ->
            println("Nombre: ${contacto.nombre}, número: ${contacto.teléfono}.")
        }
    }
}
