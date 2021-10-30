
/* Para probar código online: https://play.kotlinlang.org/  */




/***************************************************************************
 ** Expresiones y sentencias (statements) **********************************
 **************************************************************************
 * 
 * Kotlin prefiere las expresiones a las sentencias
 * 
 * Expresión es cualquier elemento sustituible por un valor
 * Sentencia es ... Java separa las sentencias por cada punto y coma
 * 
 */





fun expresiones(a: Int, b: Int) {
    val bigger = if(a > b) a else b
    val color = when {
        relax -> GREEN
        studyTime -> YELLOW
        else -> BLUE
    }
    val object = try {
        gson.fromJson(json)
    } catch (e: Throwable) {
        null
    }
}
*/


// ------------------------------------------------------------------------ //


/* Función que utiliza declaraciones (statement) */
fun canVoteStatement(name: String, age: Int): String {
    var status: String

    if (age > 17) {
        status = "sí, puede votar" // declaracion
    } else {
        status = "no, no puede votar"
    }
    return "$name, $status"
}

/* Función equivalente a la anterior pero con una expresión */
fun canVoteExpression(name: String, age: Int): String {
    val status = // una única declaración que recibe:
        if (age > 17) "yes, please vote" else "nope, please come back" // una expresión
    return "$name, $status"

    /* Permite utilizar val en lugar de var, ya que la variable es inmutable, también
    permite inferir el tipo de status. El código es más limpio y previene errores. */
}

fun canVoteExpression2(name: String, age: Int) =
    if (age > 17) "yes, please vote" else "nope, please come back"


// ------------------------------------------------------------------------ //


fun tryDeclaraciones(falloSimulado: Boolean): Int {
    var num: Int

    try {
        if (falloSimulado) throw RuntimeException("fail")
        num = 2
    } catch (ex: RuntimeException) {
        num = 4
    } finally {
        //...
    }
    return num
}

fun tryExpr(falloSimulado: Boolean): Int {
    return try {
        if (falloSimulado) throw RuntimeException("fail")
        2
    } catch (ex: RuntimeException) {
        4
    } finally {
        //...
    }
}


fun testTryExpr() {
    println(tryExpr(false)) //2
    println(tryExpr(true)) //4
}


// ------------------------------------------------------------------------ //

