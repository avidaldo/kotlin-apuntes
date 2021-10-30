
/***************************************************************************
 ** Cadenas de texto  **********************************
 **************************************************************************
 * 
 * https://kotlinlang.org/docs/basic-syntax.html#using-string-templates
 */


/** Uso de String templates */
fun stringTemplates() {

    var int1 = 10
    println("El número es $int1")
    // Con $nombre referenciamos el valor de una variable desde dentro de una cadena literal

    var cadena4 = "El número sigue siendo $int1";
    println(cadena4)


    val price = 12.25
    val taxRate = 0.08
    val output = "The amount $price after tax comes to $${price * (1 + taxRate)}"
    val disclaimer = "The amount is in US$, that's right in \$only"

    println(output)
    println(disclaimer)


    // Uso de cadenas literales (raw strings) en lugar de escapar caracteres
    val name = "Alejandro"
    val escaped = "El alumno preguntó: \"¿Qué tal el verano, $name?\""
    println(escaped)
    val raw = """El alumno preguntó: "¿Qué tal el verano, $name?"""
    println(raw)

    val multilinea = """Es el vecino el que elige el alcalde y es el 
        | alcalde el que quiere que sean los vecinos el alcalde. """

    println(multilinea)
    println(multilinea.trimMargin())

}


/** Igualdades de Cadenas de texto */
fun stringTemplates() {

   /* En Kotlin, a diferencia de en Java, se pueden comparar directamente Strings */

   println("hi" == "hi") // En Java sería false por ser dos objetos String distintos
   
   // Del mismo modo:

   val string1 = "Hola"
   val string2 = "Hola"

   println(string1==string2)
   

   println("hi" == "Hi")
   println(null == "hi") // false; en java daría una NullPointerException
   println("hi" == null)
   println(null == null)

}
