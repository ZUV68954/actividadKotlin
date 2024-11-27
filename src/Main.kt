val tresEnRaya: ArrayList<ArrayList<String>> = arrayListOf(
    ArrayList(), ArrayList(), ArrayList()
)

fun main() {
    val línea1: Array<String> = arrayOf("X", "X", "X")
    val línea2: Array<String> = arrayOf("X", "X", "O")
    val línea3: Array<String> = arrayOf("O", "X", "X")
    crearPartida(línea1, línea2, línea3)
    println(comprobarGanador())
}


fun crearPartida(línea0: Array<String>, línea1: Array<String>, línea2: Array<String>) {
    línea0.forEach { símbolo ->
        tresEnRaya[0].add(símbolo)
    }
    línea1.forEach { símbolo ->
        tresEnRaya[1].add(símbolo)
    }
    línea2.forEach { símbolo ->
        tresEnRaya[2].add(símbolo)
    }
}

fun comprobarGanador(): String {
    var totalX = 0
    var totalO = 0

    // Comprobar línea en horizontal
    for (j in 0..<3) {
        var x = 0
        var o = 0
        for (i in 0..<3) {
            if (tresEnRaya[j][i] == "X") {
                x++
                totalX++
            } else if (tresEnRaya[j][i] == "O") {
                o++
                totalO++
            }
        }

        // Descargo de responsablidad: Este código fue creado en base a una fórmula preestablecida.
        if (totalO >= totalX + 2 || totalX >= totalO + 2) {
            return "NULL"
        } else if (x == 3) {
            return "X"
        } else if (o == 3) {
            return "O"
        }

    }


    // Comprobar línea en vertical
    for (j in 0..<3) {
        var x = 0
        var o = 0
        for (i in 0..<3) {
            if (tresEnRaya[i][j] == "X") {
                x++
            } else if (tresEnRaya[i][j] == "O") {
                o++
            }
        }
        if (x == 3) {
            return "X"
        } else if (o == 3) {
            return "O"
        }
    }

    // Comprobar línea en diagonal de izquierda a derecha
    var x = 0
    var o = 0
    for ((j, i) in (0..<3).withIndex()) {
        if (tresEnRaya[j][i] == "X") {
            x++
        } else if (tresEnRaya[j][i] == "O") {
            o++
        }
        if (x == 3) {
            return "X"
        } else if (o == 3) {
            return "O"
        }
    }

    // Comprobar línea en diagonal de derecha a izquierda
    x = 0
    o = 0
    for ((j, i) in (2 downTo 0).withIndex()) {
        if (tresEnRaya[j][i] == "X") {
            x++
        } else if (tresEnRaya[j][i] == "O") {
            o++
        }
        if (x == 3) {
            return "X"
        } else if (o == 3) {
            return "O"
        }
    }

    // Si no es nulo, ni ha ganado X, ni ha ganado O. Tenemos un empate.
    return "EMPATE"
}