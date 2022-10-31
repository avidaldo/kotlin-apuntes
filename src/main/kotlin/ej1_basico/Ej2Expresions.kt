/** Para probar código online: https://play.kotlinlang.org/  */


/***************************************************************************
 ** Expresiones y sentencias (statements) **********************************
 ***************************************************************************
 *
 * Fuentes:
 * Programming Kotlin by Venkat Subramaniam (2019). Chapter 2
 *
 *
 * Java, C#, JavaScript otros lenguajes tradicionales más orientados a la programación imperativa
 * prefieren el uso de sentencias. Otros lenguajes (Ruby, Groovy, Haskell) priorizan el uso de expresiones.
 *
 * Kotlin prefiere las expresiones a las sentencias.
 *
 * Las sentencias no devuelven nada y son una fuente de efectos secundarios (side effects).
 * Un efecto secundario es un cambio de estado: modificar una variable, escribir un fichero...
 *
 * Expresión es cualquier elemento sustituible por un valor.
 *
 *
 * TODO: Revisión terminológica: ¿intrucción vs sentencia?
 */


/** Función que utiliza sentencias (statement). Escrita al estilo de Java */
fun canVoteStatement(name: String, age: Int): String {
    val status: String

    if (age > 17) { // if utilizado como sentencia
        status = "sí, puede votar"
    } else {
        status = "no, no puede votar"
    }
    return "$name, $status"
}

/** Función equivalente a la anterior pero con una expresión.
 * El if se mete dentro de la asignación (o sea, el if devuelve un valor) */
fun canVoteExpression(name: String, age: Int): String {
    val status = // podemos utilizar inferencia de tipos
        if (age > 17) "sí, puede votar" else "no, no puede votar" // if utilizado en expresion
    return "$name, $status"
}


/** Sentencia try/catch */
fun tryStatement(falloSimulado: Boolean): String {
    var salida: String

    try {
        if (falloSimulado) throw RuntimeException("Todo mal")
        salida = "Todo ha ido bien"
    } catch (ex: RuntimeException) {
        salida = "Ha habido un error: \"$ex\""
    } finally {
        //...
    }
    return salida
}


/** Expresión con try/catch */
fun tryExpression(falloSimulado: Boolean): String {
    return try {
        if (falloSimulado) throw RuntimeException("Todo mal")
        "Todo ha ido bien"
    } catch (ex: RuntimeException) {
        "Ha habido un error: \"$ex\""
    } finally {
        //...
    }
}

/** Para probar la anterior función */
fun testTryExpr() {
    println(tryExpression(false))
    println(tryExpression(true))
}

fun expresiones(a: UInt, b: UInt) {
    val mayor = if (a > b) a else b
    val numString = when {
        a == 0u -> "Cero"
        a == 1u -> "Uno"
        else -> "Varios"
    }
}


fun max(a: Int, b: Int): Int {
    var max = a
    if (a < b) max = b
    return max
}

/* Mejoramos la anterior utilizando una expresión simple en una línea. Kotlin no tiene operador ternario
ya que considera suficientemente clara esta opción  */
fun max2(a: Int, b: Int): Int {
    return if (a > b) a else b
}

/* que, siendo el cuerpo de la función una única expresión, puede expresarse asi: */
fun max3(a: Int, b: Int) = if (a > b) a else b // Nos permite inferir el tipo y ahorrarnos el return.







