/***************************************************************************
 ** Scope functions  **********************************
 **************************************************************************
 *
 * https://kotlinlang.org/docs/scope-functions.html
 *
 *
 * Las funciones de ámbito (scope) buscan simplemente mejorar la legibilidad del código
 *
 */

private class PersonaSF(val nombre: String, var edad: Int) {
    fun incrementaEdad() {
        edad++
    }

    override fun toString(): String {
        return "$nombre, $edad años"
    }
}

fun testScopeFunctions() {
// Código al estilo Java
    val alice = PersonaSF("Alice", 20) // Necesitamos una variable para el objeto
    println(alice) // Utilizamos esa variable
    alice.incrementaEdad()
    println(alice)

/* Código creando un ámbito temporal con let. Nos evita crear una variable para
operar con el objeto y llamarla repetidamente.
 */
    PersonaSF("Bob", 20).let {
        println(it)
        it.incrementaEdad()
        println(it)
    }

}