/**************************************************************************
 ** Null Safety ***********************
 **************************************************************************
 *
 *
 * En general intentaremos evitar los tipos nullables siempre que sea posible
 *
 * Fuentes:
 * https://kotlinlang.org/docs/null-safety.html
 * https://www.baeldung.com/kotlin/not-null-assertion
 */




fun main() {


    fun nickName(name: String): String? {
        if (name == "William") {
            return "Bill"
        }
        return null //ERROR de compilación, no puede devolver null
    }


    /** Nothing */

    var nullString = null // Se infiere el tipo Nothing?
    println(nullString)
    // nullString = "Hola" // No es reasignable a "String?"

    var nullString4: Nothing? = null // TODO

    var nullString2: String
    // nullString2 = null // Error, la variable no es nullable


    var nullString3: String? = null // La interrogación indica que una variable es nullable

//println(nullString3) // El compilador detecta String y String? como dos tipos distintos,
// así, no hay posibilidad de que salte una nullPointerException por recibir null donde se espera un String
    println(nullString3.toString()) // se puede
    println(null.toString())
    println(nullString3?.javaClass.toString())


// 4. Con let
// https://kotlinlang.org/docs/scope-functions.html#let
    nullString3?.let {
        println(nullString3)
    } ?: run {
//            println(nullString3!!) // Non-null asserted: Afirmamos al compilador de que la variable no es null
        // Así podemos forzar una NullPointerException
    }


    var palabra: String? = "hola"

// Tradicional
    val longitud: Int
    if (palabra != null) {
        longitud = palabra.length
    } else {
        longitud = -1
    }

// Asignación directa
    var longitud2 =
        if (palabra != null) {
            palabra.length
        } else {
            -1
        }

// o, en una línea:
    longitud2 =
        if (palabra != null) palabra.length else -1 // No hay operador ternario en Kotlin


// Operador Elvis -- Null coalescing
    longitud2 = palabra?.length ?: -1 // hay que usar una safe call

// Tomado de Groovy, donde null se considera falso. No funciona igual en otros lenguajes.


// if (null) Log.i(LOG_TAG,"null as boolean no permitido")

    val booleano = false

    val booleano2 = booleano

    println(longitud2.toString())


//   In Kotlin, the Elvis operator returns its left-hand side if it is not null, and its right-hand side otherwise.[8] A common pattern is to use it with return, like this: val foo = bar() ?: return



   // https://kotlinlang.org/docs/null-safety.html
    fun main() {
        var str: String? = "Hola Mundo!"
        println(str!!.length)
        str = null
        // println(str!!.length) //No complila??? porque con la "!!" impide que str pueda ser null para llamar al length
    }

}

// When using a nullable type, the ?. or !! operators have to be used to access the nullable variable. 

/*

Using ?. avoids a crash by returning null should showAnswerButton be null for some reason.

showAnswerButton?.setOnClickListener { */
/* *//*
 }
This is equivalent to the following code in Java:

if (showAnswerButton != null) {
    showAnswerButton.setOnClickListener(*/
/* *//*
);
}
The !! operator would cause a crash in the following code if showAnswerButton were null:

showAnswerButton!!.setOnClickListener { */
/* *//*
 }*/


// https://stackoverflow.com/questions/66751722/kotlin-lateinit-vs-computed-property

