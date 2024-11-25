fun main() {
    if (anagrama()) {
        println("Las palabras son anagramas.")
    } else {
        println("Las palabras no son anagramas.")
    }
}

fun anagrama(): Boolean {
    println("Introduzca la primera palabra:")
    val palabra1: String = readln().lowercase()
    println("Introduzca la segunda palabra:")
    val palabra2: String = readln().lowercase()
    val letras1: CharArray = palabra1.toCharArray()
    val letras2: CharArray = palabra2.toCharArray()
    if (letras1.size == letras2.size) {
        for (i in letras1.indices) {
            if (!(letras2.contains(letras1[i]))) {
                return false
            }
            if (!(letras1.contains(letras2[i]))) {
                return false
            }
        }
        return true
    } else {
        return false
    }
}