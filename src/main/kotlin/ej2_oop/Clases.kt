package ej2_oop

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


/**
 * GETTERS & SETTERS (BACKING FIELDS)
 *
 * Aunque el acceso a las propiedades puede recordar al acceso a campos (fields) en Java, no es realmente así:
 * Las propiedades tienen normalmente un campo por debajo (backing field) que es la parte de la propiedad que mantiene
 * su valor en memoria.
 * Cuando accedemos a una propiedad, realmente estamos llamando implícitamente a su getter y cuando lo reasignamos
 * se está llamando a su setter. Estos están creados por el compilador, pero pueden modificarse.
 *
 * https://kotlinlang.org/docs/properties.html
 * https://stackoverflow.com/questions/44368741/expecting-member-declaration-in-kotlin
 * https://www.baeldung.com/kotlin/getters-setters
 **/

/** Se pueden definir getters y setters personalizados para una propiedad. */
class Prueba2 {
    var counter = 0 // inicializador a 0
        set(value) {
            if (value >= 0) // Almacenamos solo si la asignación es positiva (p. ej.)
            /** El setter siempre debe asignar el valor recibido (value) al campo (field) de la propiedad */
                field = value
            // counter = value // ERROR StackOverflow: setter recursivo
        }
        get() {
            println("Log: lectura de contador")
            return field
        }
}

fun textPrueba2() {
    val p = Prueba2()
    p.counter = 2
    /** Al asignar a la propiedad, se llama al setter, al que se le pasa el "2" como "value". El setter lo asignará
     * al campo (field) donde la propiedad almacena su valor */
}



class Rectangulo2(private val longitud: Int, private val anchura: Int) {
    private val area get() = this.longitud * this.anchura
    /* Cada vez que se accede a la propiedad, se está llamando a su getter.
    No es necesario el tipo al ser inferible por el getter */

    override fun toString() = "Rectángulo con ${area}px de área ($longitud*$anchura)"
}

fun testRentangulo() {
    println(Rectangulo2(3, 4))
}



/** https://stackoverflow.com/questions/41440750/kotlin-why-do-i-need-to-initialize-a-var-with-custom-getter */
class PruebasBackingFields () {
    /* Si creamos una val con getter personalizado que no utiliza el identificador "field", este campo no es generado */
    val saludo1 get() = "hola" // Absurdo, pero no necesitaría inicializar el campo

/*    val saludo2: String// Property must be initialized
        get() = field*/

    /** Con var, el campo es siempre generado automáticamente (ya que el campo puede cambiar), así que es necesario
    inicializar */

/*    var saludo3: String // Property must be initialized
        get() = "hello"*/

    /** Para forzar una propiedad var sin campo, podríamos recurrir a una backing property: */
    private var _saludo4: String = ""
    var saludo4: String
        get() = "hola"
        set(value) { _saludo4 = value}

}



/**************************************************************************
 * Backing properties
 *
 * (Usado por el View Binding para Fragments)
 */

class Tabla() {
    private var _table: Map<String, Int>? = null  // la propiedad de respaldo es privada y nullable
    public val table: Map<String, Int> // nos permite utilizar una propiedad no nullable apoyándonos en la de respaldo
        get() {
            if (_table == null) {  // Si la propiedad de respaldo no existe, la creamos
                _table = HashMap()
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }
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


