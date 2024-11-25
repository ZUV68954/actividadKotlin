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

    // Se comprueba que ambas palabras tengan la misma cantidad de letras.
    if (palabra1.length == palabra2.length) {
        for (i in palabra1.indices) {

            // Se comprueba que todas las letras de la segunda palabra se encuentran en la primera.
            if (!(palabra2.contains(palabra1[i]))) {
                return false
            }

            // Se comprueba que todas las letras de la primera palabra se encuentran en la segunda.
            if (!(palabra1.contains(palabra2[i]))) {
                return false
            }
        }

        // Si se han pasado todas las comprobaciones, se llega aquí y las palabras son anagramas.
        return true
    } else {
        return false
    }
}