package p3_functional

/**
 *
 * https://kotlinlang.org/docs/fun-interfaces.html#sam-conversions
 */


interface InterfazConDosFunciones {
    fun funUno(i: Int): Boolean
    fun funDos(): Unit
}

interface InterfazConUnaFuncion {
    fun funUno(i: Int): Boolean
}


fun interface InterfazSAM {
    fun funUno(i: Int): Boolean
}

val objetoQueImplementaInterfazConDosFunciones = object : InterfazConDosFunciones {
    override fun funUno(i: Int) = true
    override fun funDos() {
        println("Funcion Dos")
    }
}

val objetoQueImplementaInterfazConUnaFuncion = object : InterfazConUnaFuncion {
    override fun funUno(i: Int) = true
}
// TODO: Revisar ejemplo de formas de llamar a lambdas en Kotlin (EventosKotlin.Ej01)

/*val objetoQueImplementaInterfazSAM = object : InterfazSAM {
    override fun funUno(i: Int) = true
}*/

val objetoQueImplementaInterfazSAM = InterfazSAM { true }