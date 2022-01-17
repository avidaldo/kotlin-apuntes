import kotlin.random.Random

/**************************************************************************
 ** Enums ***********************
 **************************************************************************
 *
 * Un enum es una clase que define un tipo declarando declarando todos los posibles
 * valores que puede tomar el tipo.
 *
 *
 * Fuentes:
 * https://kotlinlang.org/docs/enum-classes.html
 * https://www.baeldung.com/kotlin/enum
 * https://play.kotlinlang.org/byExample/03_special_classes/02_Enum
 */

/** Enum que define un nuevo tipo "Estado" que puede tener uno de los 3 valores */
enum class Estado {
    ESPERA, EJECUTANDO, TERMINADO;
}

fun testEstado() {
    val arrayEstados = Estado.values() // Convertimos a array para poder acceder a uno aleatorio
    val estadoAleatorio = arrayEstados[Random.nextInt(arrayEstados.size)]
    println(
        when (estadoAleatorio) {
            Estado.ESPERA -> "Está en espera"
            Estado.EJECUTANDO -> "Está ejecutándose"
            Estado.TERMINADO -> "Ha terminado"
        }
    )
}


/** Enum que contiene propiedades y métodos (no deja de ser una clase) */
enum class Color(val rgb: Int) { // Definimos un constructor con un atributo

    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    /** Método que comprueba si el color actual contiene algo de rojo */
    fun containsRed() = (this.rgb and 0xFF0000 != 0) // Aplicamos una máscara binaria
}

fun main() {
    val red = Color.RED // Variable de tipo (inferido) Color
    println(red) // RED
    println(red.rgb)
    println(Color.BLUE.rgb)
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    println(Color.YELLOW.containsRed())
}