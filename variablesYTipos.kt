
/* Para probar código online: https://play.kotlinlang.org/  */




/***************************************************************************
 ** Tipos de variables: var / val / const **********************************
 **************************************************************************
 * 
 * https://www.baeldung.com/kotlin/const-var-and-val-keywords
 */


 fun testVariables() { // declaración de una función

    // Utilizaremos "var" para variables mutables
    var variable1: Int // Declaración de una variable mutable de tipo Int
    variable1 = 3
    variable1 = 4 // reasignación de la variable

    /** Las variables en Kotlin no pueden ser null a no ser que se declaren nullables **/
    // variable1 = null  // Error de compilación

    var variable2: Int? // Declaración de una variable mutable Int nullable
    variable2 = 3
    variable2 = null // Ahora sí puede declararse como null


    /** Kotlin permite (y recomienda) la inferencia de tipos **/

    var variable3 = 3 // No es necesario indicar el tipo si se inicializa, ya que se inferirá
    // variable3 = "adios" // Error. Hay inferencia de tipos pero no tipado dinámico
    // variable3 = null // Cuando se infiere un tipo por que ya se ha asignado, no es nullable



    /** Utilizaremos val para variables inmutables (final) **/

    val variable4 : String  // Declaración de una variable final
    variable4 = "contante" // Inicialización de la variable en tiempo de ejecución
    // variable4 = "otra cosa" // Error, no puede reasignarse. La variable es inmutable
    
    // Para el caso de Strings, la clase StringBuilder sí es mutable (interface Appendable), al igual que en Java
    val variable5 = StringBuilder("Hola")
    // variable5 = StringBuilder("Hola mundo") //ERROR. Inmutabilidad de referencia. No se puede reasignar
    variable5.append(" mundo") // Pero no inmutabilidad de objeto

    println(variable5)

 }



/** const se utilizará para variables que son conocidas en tiempo de compilación (static).
 * Es por ello que tendrán que ser declaradas como varibles globales (una constante no puede
 * definirse dentro de una función ya que a la función se la llama en ejecución)
 */
 const val KEY_COSA = "cosa"
 const val PI = 3.14


 fun testVariablesYContantes() {

   testVariables()

   println(PI)
}






/***************************************************************************
 ** Tipos de datos **********************************
 ***************************************************************************/


 /** Numéricos enteros (Int, Short, Long, Byte) */
 fun tiposDatos() {

    var int1 = 10

    val long1 = 10L
    val int2: Int = 10 // Redundante
    val long2: Long = 10
    val long3: Long = 10L // Redundante


    // Numéricos decimales (Double, Float)
    val decimal1 = 10.5  // double por defecto
   println(decimal1::class.java) // Reflection de Java
   println(decimal1.javaClass)


   val decimal2 = 10.5f
   println(decimal2.javaClass)


   var decimal3: Double = 10.5
   val decimal4: Float = 10.5f

   decimal3 = int1.toDouble()


   // Booleanos
   val boolean = false


 }




/***************************************************************************
 ** Operadores **********************************
 ***************************************************************************/


fun operadores() {
    val valor1 = 5
    val valor2 = 2

    val division = valor1 / valor2
    println(division.toDouble())
    val division2 = valor1 / valor2.toDouble()
    println(division2)

    val igualdad = valor1 == valor2

    println(igualdad)

}