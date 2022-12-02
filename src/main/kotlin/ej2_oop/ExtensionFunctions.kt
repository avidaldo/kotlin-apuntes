package ej2_oop

/**************************************************************************
 * Funciones de extensión (extension functions)
 *
 * https://kotlinlang.org/docs/extensions.html#extension-functions
 * https://www.baeldung.com/kotlin/extension-methods
 * */


class ClaseAExtender {
    val propiedad = 0

    fun funcion1() {
        println(propiedad)
    }

    fun funcion2() {
        println("Hola")}
}

fun ClaseAExtender.funcion3(): Int {
    return propiedad

}

fun main() {
    val p = ClaseAExtender()
    println(p.funcion1())
    println(p.funcion2())
    println(p.funcion3())
}
