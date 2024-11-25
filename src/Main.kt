fun main() {
    val expresión = "(a"
    if (totalExpresiones(expresión) != -1) {
        if (orden(expresión)) {
            println("Sí")
        } else {
            println("La expresión no es correcta.")
        }
    } else {
        println("La expresión no es correcta.")
    }
}

fun orden(expresión: String): Boolean {
    var expresiones: CharArray = expresión.toCharArray()
    var abiertoLlave = 0
    var abiertoCorchete = 0
    var abiertoParéntesis = 0
    expresiones.forEach { letra ->
        if (letra == '[') {
            abiertoLlave++
        } else if (letra == '{') {
            abiertoCorchete++
        } else if (letra == '(') {
            abiertoParéntesis++
        } else if (letra == ']' && abiertoLlave == 0) {
            return false
        } else if (letra == '}' && abiertoCorchete == 0) {
            return false
        } else if (letra == ')' && abiertoParéntesis == 0) {
            return false
        }
    }
    return true
}


fun totalExpresiones(expresión: String): Int {
    var totalExpresiones: Int = 0
    var contadorLlaves: Int = 0
    var contadorParéntesis: Int = 0
    var contadorCorchetes: Int = 0
    expresión.forEach { letra ->
        if (letra == '{') {
            contadorLlaves++
            totalExpresiones++
        } else if (letra == '}') {
            contadorLlaves--
        } else if (letra == '(') {
            contadorParéntesis++
            totalExpresiones++
        } else if (letra == ')') {
            contadorParéntesis--
        } else if (letra == '[') {
            contadorCorchetes++
            totalExpresiones++
        } else if (letra == ']') {
            contadorCorchetes--
        }
    }
    if (contadorLlaves != 0 || contadorCorchetes != 0 || contadorParéntesis != 0) {
        return -1
    }
    return totalExpresiones
}