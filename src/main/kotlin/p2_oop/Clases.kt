package p2_oop

/**************************************************************************
 ** Clases en Kotlin ***********************
 **************************************************************************
 *
 * Fuentes:
 * Venkat Subramaniam (2019). Programming Kotlin. Chapter 7
 * Duncan McGregor & Nat Pryce (2021). Java to Kotlin. A Refactoring Guidebook.
 * https://kotlinlang.org/docs/classes.html
 */




/**************************************************************************
 * Clases
 * Kotlin simplifica la creación de clases que en Java se considera que cuenta con demasiado código repetitivo
 * (boilerplate code). La gran cantidad de código que los IDEs generan automáticamente (constructores, getters, setters...)
 * se mueve del IDE al compilador. */


class CocheEstiloJava {
    val yearOfMake: Int = 0  // propiedad inmutable
    constructor(yearOfMake: Int)
}

class CocheSimplificada(val yearOfMake: Int)


/** Clase con una propiedad */
class Coche(val anho: Int)
/* Con esta notación estamos definiendo la clase Coche, con una propiedad "anho" de solo lectura (no es modificable por
ser declarada como "val"). Al mismo tiempo estamos definiendo su constructor, que recibe como argumento esa propiedad.
La línea que define la clase está definiendo el constructor principal */


fun testClases() {
    val coche = Coche(2021)  // Instancia de la clase coche llamando a su constructor principal
    println(coche.anho)  // Acceso a la variable a través de getter implícito

    class Coche2(val anhoFabricacion: Int, var color: String)

    val coche2 = Coche2(2021, "Rojo")
    coche2.color = "Verde" // Llamada implícita al setter
    println(coche2.color) // Llamada implícita al getter
}



/** Si una clase tiene un constructor primario, cualquier constructor secundario tiene que delegar al primero
 * refiriéndolo con "this" */

class Persona2(private val nombre: String) { // Declaración de clase con constructor primario y una propiedad inmutable
    private val hijos: MutableList<Persona2> = mutableListOf() // Declaración de otra propiedad inmutable (que es un puntero
    // a una lista mutable)
    constructor(name: String, padre: Persona2) : this(name) { // Constructor secundario, que llama al primario
        padre.hijos.add(this)
    }
}


/**
 * Bloque init
 *
 * https://www.baeldung.com/kotlin/init-vs-constructor-block
 * */


class Persona4(val mascotas: MutableList<Mascota> = mutableListOf())

class Mascota(propietario: Persona4) {
    init {
        propietario.mascotas.add(this)
    }
}


class Persona3(val firstName: String, val lastName: String) {
    /** Como contrapartida a la simplificación del código del constructor primario, este no puede contener código.
     * Para poder introducir código que se ejecute cuando se llama al constructor primario, existen los bloques init.
     * Cada vez que se llama al constructor, Kotlin ejecutará los bloques inir en el orden en que aparecen en el cuerpo
     * de la clase.
     */

    private val fullName: String = "$firstName $lastName".trim()
        .also { println("Log: Asignado nombre completo") }

    init {
        println("Log: Nombre completo: $fullName")
    }

    private val initials =  "${firstName.firstOrEmpty()}${lastName.firstOrEmpty()}".trim()
        .also { println("Log: Asignado iniciales") }

    init {
        println("Log: Iniciales: $initials")
    }

    constructor(lastName: String): this("", lastName) { // Constructor secundario
        println("Log: Constructor secundario: $lastName")
    }
    /* El constructor secundario sí puede contener su propia lógica de inicialización, pero un constructor secundario
    necesitará delegar en el primario, ejecutándose igualmente los bloques de inicialización. */

    private fun String.firstOrEmpty(): Char = firstOrNull()?.uppercaseChar() ?: ' '
}

fun testPersona3() {
    val p = Persona3( "Pepe", "Pérez")
    println("--")
    val p2 = Persona3("Vidal")
}

class Sample(var s : String) {
    constructor(t: String, u: String) : this(t) {
        this.s += u
    }
    init {
        s += "B"
    }
}

fun testSample() = println(Sample("T","U").s)


/** Aunque no haya constructor primario, la delegación se da implícitamente de todos modos: */
class Constructors {
    init { println("Init block") }

    constructor(i: Int) {
        println("Constructor $i")
    }
}
fun testConstructors() = Constructors(1)



/**************************************************************************
 * PROPIEDADES (properties)
 */

class Prueba {
    // Declaración de variable mutable
    var inicializada = 1
    //var todoPorDefecto // ERROR: se requiere al menos un inicializador


    // Declaraciones de propiedades de solo lectura
    val simple: Int? = null // tipo Int, getter por defecto, debe inicializarse en el constructor
    val inferredType = 1 // has type Int and a default getter
    // las variables no mutables no permiten setters

}






/**************************************************************************
 * Interfaces
 **/


/** Clase que representa un rectángulo y que implementa la interfaz comparable */
class Rectangulo(private val longitud: Int, private val anchura: Int) : Comparable<Rectangulo> {

    /** Método que recibe otro rectángulo para poder compararlo con el objeto que llama al método */
    override fun compareTo(other: Rectangulo): Int {
        val area = longitud * anchura
        val areaOtro = other.longitud * other.anchura

        return when { // Definimos que los rectángulos se comparen en función de su área
            area == areaOtro -> 0
            area < areaOtro -> -1
            else -> 1
        }
    }

    override fun toString() = "ej2_oop.Rectangulo con longitud = $longitud y anchura = $anchura"

}

fun comparaRectangulos() {
    var obj1 = Rectangulo(5, 5)
    var obj2 = Rectangulo(4, 4)

    // Comprobamos si el rectangulo 1 es mayor que el rectangulo 2
    println("${obj1 > obj2}")

}


