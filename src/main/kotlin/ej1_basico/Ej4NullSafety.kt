import kotlin.random.Random

/**************************************************************************
 ** Null Safety ***********************
 **************************************************************************
 *
 * Una crítica recurrente a muchos lenguajes, como Java, es que sea posible llamar a un método de una referencia a null,
 * desencadenando (ej java) una NullPointerExceptionNullPointerException (NPE).
 *
 * Kotlin permite especificar para cualquier variable, sea del tipo que sea, si puede o no ser nullable.
 * En general intentaremos evitar los tipos nullables siempre que sea posible.
 *
 * Fuentes:
 * https://kotlinlang.org/docs/null-safety.html
 * https://play.kotlinlang.org/byExample/01_introduction/04_Null%20Safety
 * https://www.baeldung.com/kotlin/not-null-assertion
 */


const val PRUEBA = true

fun main() {

    var string1: String = "Esta variable no puede ser null"
    // string1 = null // Error, la variable no es nullable

    var stringNoNullable = "Esta variable no puede ser null" // Infiere el tipo String
    // string2 = null // Error, la variable no es nullable

    /** Si queremos inicializar una variable pero permitir que pueda ser null eventualmente: */
    var stringNullable: String? = "Esta variable sí puede ser null" // La interrogación indica que una variable es nullable

    if (Random.nextBoolean()) stringNullable = null // La condición de Schrodinger
    // stringNullable = "hola"

    val lenght2 = stringNoNullable.length
    // val lenght3 = stringNullable.length
    /* Nos avisa en compilación de que el tipo puede ser null. En Java sería una NullPointerException en ejecución */


    /** Comprobando null en asignación. Forma clásica: */
    val lenght3 = if (stringNullable != null) stringNullable.length else -1 // Asigna -1 como valor cuando la cadena es null


    /** Función que devuelve la longitud de una cadena de texto */
    fun checkStrings(b: String?) =
        if (b != null && b.length > 0) {
            println("Longitud de la cadena: ${b.length}")
        } else {
            println("Cadena vacía")
        }
    checkStrings(stringNullable)


    /** Safe call operator (?.)
     * El operador ?. devuelve null cuando la referencia es null, evitando la NPE */
    println(stringNullable?.length)
    println(stringNoNullable?.length) // Safe call innecesario

    /* Permitiría llamadas como ésta: */
    //bob?.departmento?.jefe?.nombre // Devolvería null si cualquiera de los atributos en null



    /** Manejo de lista con valores a null */

    fun funNoNullInput(item: String) {   /* Función que no acepta null como argumento */
        println(item)
    }

    val listWithNulls: List<String?> = listOf("Kotlin", null) // lista con 2 elementos, uno a null

    println("-- Sin let:")
    for (item in listWithNulls) {
        println(item)  // println permite Strings nullables
        // funNoNullInput(item)
    }
    println("-- Con let:")
    for (item in listWithNulls) {
        item?.let { funNoNullInput(it) } // Para los elementos null, no se ejecuta el contenido del let
    }


    /** Operador Elvis ?:
     * El operador Elvis indica el valor alternativo en caso de que la expresión devuelva null */


    var longitudNoNullable : Int
    var longitudNullable : Int?
    longitudNoNullable= if (stringNullable != null) stringNullable.length else -1 // Asigna -1 como valor cuando la cadena es null
    println(longitudNoNullable)
    // longitudNoNullable= stringNullable?.length // No podría usarse aquí porque no se acepta null como retorno
    longitudNoNullable = stringNullable?.length ?: -1 // Equivalente a la expresión if anterior
    println(longitudNoNullable)


    /** Not-null assertion operator (!!)
     * Permite indicar al compilador que se asume que la variable, aunque nullable, no será null.
     * En caso de que lo sea, lanzará un NPE, como ej java */

    println(stringNullable!!.length) // Si es null, lanza NPE
    println(stringNoNullable!!.length)




    }


