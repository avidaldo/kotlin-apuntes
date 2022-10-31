package ej2_oop

import java.math.BigDecimal

/**************************************************************************
 * Objetos
 *
 * Object expressions
 *
 * Kotlin permite crear objetos de clases anónimas (clases que no han sido declaradas), que pueden ser útiles
 * cuando solo necesitamos un determinado objeto y no un tipo de objeto del que se vayan a crear múltiples
 * instancias.
 *
 * Es posible crear objetos desde cero o también heredan de clases existentes (pero sin crear la clase hija) o
 * implementando interfaces.
 *
 * https://kotlinlang.org/docs/object-declarations.html
 * https://www.baeldung.com/kotlin/objects
 * */

fun testingObjetosAnonimos() {

    val obj = object { // Creación de un objeto anónimo
        val pregunta = "el sentido de la vida, el universo y todo lo demás"
        val respuesta = 42

        override fun toString(): String {
            return "La respuesta a \"${pregunta}\" es ${respuesta}"
        }
    }

    println("La respuesta a \"${obj.pregunta}\" es ${obj.respuesta}")
    println(obj)
}



/** Los objetos anónimos pueden servir para implementar interfaces, del mismo modo que con
las clases anónimas internas de Java.
Por ejemplo, para los Listeners (ver el proyecto EventosKotlin, Ej01VariantesCallbackActivity) */

val aRunnable = object : Runnable { // La interfaz Runnable está diseñada para crear hilos (threads) de ejecución
    override fun run() {
        println("Esto se ejecutará en un hilo")
    }
}

/** Como Runnable es una interfaz con un único método abstracto (single abstract method interface), equivalente
 * a una interfaz funcional de Java, es simplificable a una lambda */

val aRunnable2 = Runnable { println("Esto se ejecutará en otro hilo") }

fun llamaRunnables() {
    aRunnable.run()
    aRunnable2.run()
}


/**************************************************************************
 * Object declaration (Singleton)
 *
 * El patrón singleton permite crear clases que garanticen que, de estar instanciadas, siempre se devuelve el mismo
 * objeto. Es un modo de garantizar que una clase solo tiene un único objeto.
 * (Singleton en Java: https://es.wikipedia.org/wiki/Singleton#Java)
 * En Kotlin esto se simplifica, permitiendo crear directamente objetos sin necesidad de que sean una instancia
 * de una clase. De este modo. Estos objetos son equivalentes a un patrón singleton de Java. En estos casos,
 * el objeto debe declararse en lugar de utilizar la expresión.
 *
 * https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
 *
 * */


class Producto(val id: Int, var nombre: String, var precio: BigDecimal)

object CestaDeLaCompra {
    val lista : MutableList<Producto> = mutableListOf()
}

/* En una app de una tienda, se puede utilizar un singleton para garantizar que el usuario
solo tiene una única cesta de la compra. */





