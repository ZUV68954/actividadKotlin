fun main() {
    println("Introduce dos palabras para comprobar si son un anagrama:")
    val palabra1 = invertirPalabra(introducirPalabra())
    val palabra2 = introducirPalabra()
    if (compararPalabras(palabra1, palabra2)) {
        println("Las palabras son un anagrama.")
    } else {
        println("Las palabras no son un anagrama.")
    }
}

fun compararPalabras(palabra1: String, palabra2: String): Boolean {
    return palabra1 == palabra2
}

fun introducirPalabra(): String {
    println("Introduce una palabra:")
    return readln().lowercase()
}

fun invertirPalabra(palabra: String): String {
    return palabra.reversed()
}