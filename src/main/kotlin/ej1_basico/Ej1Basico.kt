/** Para probar código online (más ligero): https://play.kotlinlang.org/  */


/**************************************************************************
 ** Elementos básicos: variables, tipos, operadores ***********************
 **************************************************************************
 *
 * Fuentes:
 * https://www.baeldung.com/kotlin/const-var-and-val-keywords
 * Programming Kotlin by Venkat Subramaniam (2019). Chapter 2
 */


/** Función ej2_oop.extra.main para ejecutar el fichero */
fun main() {
    tiposVariables()
    //tiposDatosNumericos()
    //stringTemplates()
    //igualdadStrings()
}

/***************************************************************************
 ** Tipos de variables: var / val / const **********************************/
fun tiposVariables() { // declaración de una función

    /** Utilizaremos "var" para variables mutables */
    var variable1: Int // Declaración de una variable mutable de tipo Int
    variable1 = 3
    variable1 = 4 // reasignación de la variable

    /** Las variables en Kotlin no pueden ser null a no ser que se declaren nullables **/
    // variable1 = null  // Error de compilación

    var variable2: Int? // Declaración de una variable mutable Int nullable
    variable2 = 3
    variable2 = null // Ahora sí puede declararse como null


    /** Kotlin tiene tipado estático, pero permite (y recomienda utilizar) la inferencia de tipos **/

    var variable3 = 3 // No es necesario indicar el tipo si se inicializa, ya que se inferirá
    // variable3 = "adios" 
    /* Error. Hay inferencia de tipos pero no tipado dinámico. No se puede asignar un tipo nuevo a
    una variable que ya tiene uno asignado (aunque sea por inferencia) */
    // variable3 = null // Cuando se infiere un tipo por que ya se ha asignado, no es nullable


    /** Utilizaremos val para variables inmutables (final) **/

    val variable4: String  // Declaración de una variable inmutable
    variable4 = "contante" // Inicialización de la variable en tiempo de ejecución
    // variable4 = "otra cosa" // Error, no puede reasignarse. La variable es inmutable

    /** Al igual que sucede con final en Java, la referencia al objeto es inmutable, pero
    eso no significa que el objeto en sí lo sea: */

    // La clase StringBuilder sí es mutable (interface Appendable), al igual que pasa en Java
    val variable5 = StringBuilder("Hola")
    // variable5 = StringBuilder("Hola mundo") //ERROR. Inmutabilidad de referencia. No se puede reasignar
    variable5.append(" mundo") // Pero no inmutabilidad de objeto

    println(variable5)

    /** Las variables mutables son lo más común en programación imperativa, pero un tabú en funcional
    * En cualquier caso, pueden ser una fuente de errores y dificultan la legibilidad del código.
    * En general, la filosofía de Kotlin es utilizar val siempre y var solo cuando sea estrictamente necesario. */

    // Ejemplo de código confuso por uso de variables mutables:
    var factor = 2
    fun doubleIt(n: Int) = n * factor
    factor = 0
    println(doubleIt(2))  // 0


    /** const se utilizará para variables que son conocidas en tiempo de compilación (static).
     * Es por ello que tendrán que ser declaradas como varibles globales (una constante no puede
     * definirse dentro de una función ya que a la función se la llama en ejecución).
     * Hay que tener en cuenta también que Kotlin no requiere como Java que todo esté dentro de
     * clases.
     */
    println(KEY_COSA)
    println(PI)
}

const val KEY_COSA = "cosa"
const val PI = 3.14


/***************************************************************************
 ** Tipos de datos numéricos ****************************************************/


/** Numéricos enteros (Int, Short, Long, Byte) */
fun tiposDatosNumericos() {

    val int1 = 10

    /** Kotlin incorpora tipos no-negativos (unsigned) */
    val intUnsigned: UInt
    intUnsigned = 10u
    var intUnsignedInfered = 10u
    intUnsignedInfered = 0u

    val long1 = 10L
    val int3: Int = 10 // Redundante
    val long2: Long = 10
    val long3: Long = 10L // Redundante

    // Numéricos decimales (Double, Float)

    val decimal1 = 10.5  // double por defecto
    println(decimal1::class.java) // Reflection (ver reflection.kt)
    println(decimal1.javaClass)

    val decimal2 = 10.5f
    println(decimal2.javaClass)

    var decimal3: Double = 10.5
    val decimal4: Float = 10.5f

    decimal3 = int1.toDouble()


    /* Operadores */

    val valor1 = 5
    val valor2 = 2

    val division = valor1 / valor2
    println(division.toDouble())
    val division2 = valor1 / valor2.toDouble()
    println(division2)


    // Booleanos
    val boolean = false

    val igualdad = valor1 == valor2
    println(igualdad)  // false

}




/***************************************************************************
 ** Cadenas de texto  **********************************
 **************************************************************************
 *
 * https://kotlinlang.org/docs/basic-syntax.html#using-string-templates
 */


/** Uso de String templates: Cadenas de texto en las que podemos introducir variables o expresiones */
fun stringTemplates() {

    var int1 = 10
    println("El número es $int1")
    // Con $int1 referenciamos el valor de una variable desde dentro de una cadena literal

    var cadena4 = "El número sigue siendo $int1";
    println(cadena4)


    /** Con ${expresion} puede introducirse en el literal una expresión (cualquier código que devuelve un valor).
     * No solo una variable */
    val price = 12.25
    val taxRate = 0.08
    val output = "The amount $price after tax comes to $${price * (1 + taxRate)}"
    val disclaimer = "The amount is in US$, that's right in \$only"

    println(output)
    println(disclaimer)


    /** Uso de cadenas literales (raw strings) en lugar de escapar caracteres **/
    val name = "Alejandro"
    val escaped = "El alumno preguntó: \"¿Qué tal el verano, $name?\""
    println(escaped)
    val raw = """El alumno preguntó: "¿Qué tal el verano, $name?"""
    println(raw)

    val multilinea = """Es el vecino el que elige el alcalde y es el 
    | alcalde el que quiere que sean los vecinos el alcalde. """

    println(multilinea)
    println(multilinea.trimMargin())


    /* Ojo con los problemas de mutabilidad: */
    var factor = 2
    fun doubleIt(n: Int) = n * factor /* Esta función queda vinculada a la variable,
    y se evaluará el valor de ésta en el momento en que se llame a la función */
    var message = "El factor es $factor"  /* El string template se evalua en el momento
    en que la variable "mensaje" es creada */
    factor = 0
    println(doubleIt(2))  // 0
    println(message)  // El factor es 2


}


/** Igualdades de Cadenas de texto */
fun igualdadStrings() {
    /** En Kotlin, a diferencia de en Java, se pueden comparar directamente Strings */

    println("hi" == "hi") // En Java sería false por ser dos objetos String distintos, habría que utilizar .equals()

    // Del mismo modo:
    val string1 = "Hola"
    val string2 = "Hola"

    println(string1 == string2)


    println("hi" == "Hi")
    println(null == "hi") // false; en java daría una NullPointerException
    println("hi" == null)
    println(null == null)

    //println("h" == 'h')
    /* Error: no se puede comparar un String con un Char. type safety
    Kotlin enfatiza la seguridad de tipos (type safety) */


}