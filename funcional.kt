/** Como ya se comentó, el tratamiento de funciones como objetos (First-class functions) permite el uso de funciones de
 * orden superior (higher-order functions).
 */


fun main(args: Array<String>) {
    val company = { println("GeeksforGeeks")}

    // invoking function method1
    company()

    // invoking function method2
    company.invoke()
}



/* the map function, which takes, as its arguments, a function and a list, and returns the list formed by applying the
function to each member of the list. For a language to support map, it must support passing a function as an argument.
 */


fun mapList() {



    val chars = listOf('a', 'ω', '1', 'ŉ', 'A', '+', 'ß')
    val uppercaseChar = chars.map { it.uppercaseChar() }
    val uppercase = chars.map { it.uppercase() }
    println(uppercaseChar) // [A, Ω, 1, ŉ, A, +, ß]
    println(uppercase) // [A, Ω, 1, ʼN, A, +, SS]



    var nombre = "Alejandro"
    nombre.map { it.uppercaseChar() }
    println("Nombre convertido a mayúsculas: $nombre")

    val string = "kotlin"
    println(string.map { it.uppercaseChar() }) // [K, O, T, L, I, N]



    val chars2 = charArrayOf('A', 'B', 'C');

    val str = chars2.let { String(it) }
    print(str)        // ABC

}

fun reduceArrayASuma() {
    var array = arrayOf(1, 2, 3, 4)  // Creación de un array en Kotlin

    var sum = 0 // Variable para acumular la suma, que será necesaria para algorimos imperativos

    /* El for imperativo tradicional de C (presente en Java) no existe en Kotlin.
    Su for es como el foreach de Java 8 */
    for (i in array) {
        sum += array[i]
    }
    println("sum=$sum")

    // Podemos evitar el for llamando a la función forEach
    sum = 0
    array.forEach { sum += it }
    println("sum=$sum")


    /* La programación funcional permite utilizar val en lugar de var, ya que la variable
    es inmutable, también permite inferir su tipo precisamente por no tener que modificar su
    valor al iterar. El código es más limpio y previene errores. No se dan efectos secundarios */

    /* Reduce es una función de orden superior que permite reducir una lista a un único valor (acc) mediante la función
    de callback que se pasa para aplicar */
    val sumf1 = array.reduce { acc, i -> acc + i }
    println("sum=$sumf1")


    val sumf2 = array.sum()
    println("sum=$sumf2")


    println("sum=${array.sum()}")
}

// TODO: Scoped functions
/* Para forzar a que haya al menos un parámetro: */
fun maxOrNull(num1: Int, vararg numbers: Int) =
    numbers.toMutableList().let {
        it.add(num1)
        it.maxOrNull()
    } /* Por cierto, acabo de sobrecargar maxOrNull() creando una ambiguedad: */
// maxOrNull(1) // Error, no sabe cual de las funciones sobrecargadas se corresponde



