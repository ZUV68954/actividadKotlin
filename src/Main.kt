import kotlin.system.exitProcess

var pista: String = "_|_|_"
fun main() {
    val acciones: Array<String> = arrayOf("correr", "saltar", "correr", "saltar", "correr", "saltar", "correr")
    if (pistaCorrecta(pista)) {
        if (accionesCorrectas(acciones)) {
            if (carrera(acciones)) {
                println("$pista true")
            } else {
                println("$pista false")
            }
        } else {
            println("Las acciones son ilegales.")
            exitProcess(-1)
        }
    } else {
        println("La pista no es correcta.")
        exitProcess(-1)
    }
}

fun carrera(acciones: Array<String>): Boolean {
    val obstáculos = pista.toCharArray()
    var correcto = true
    for (i in acciones.indices) {
        try {
            if (acciones[i] == "correr" && obstáculos[i] != '_') {
                obstáculos[i] = '/'
                correcto = false
            } else if (acciones[i] == "saltar" && obstáculos[i] != '|') {
                obstáculos[i] = 'x'
                correcto = false
            } else if (acciones[i] == "correr" && obstáculos[i] == '_') {
            // Correcto
            } else if (acciones[i] == "saltar" && obstáculos[i] == '|') {
            // Correcto
            } else {
                obstáculos[i] = '?'
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            // obstáculos.add('?')
        }
    }
    pista = obstáculos.joinToString()
    return correcto
}

fun pistaCorrecta(pista: String): Boolean {
    val obstáculos = pista.toCharArray()
    var contador = 0
    obstáculos.forEach { obstáculo ->
        when (obstáculo) {
            '_' -> contador++
            '|' -> contador++
        }
    }
    return contador == obstáculos.size
}

fun accionesCorrectas(acciones: Array<String>): Boolean {
    var contador = 0
    acciones.forEach { acción ->
        when (acción) {
            "correr" -> contador++
            "saltar" -> contador++
        }
    }
    return contador == acciones.size
}