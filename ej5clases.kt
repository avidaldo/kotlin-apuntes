/**************************************************************************
 ** Programación Orientada a Objetos en Kotlin ***********************
 **************************************************************************
 *
 * Fuentes:
 * Programming Kotlin by Venkat Subramaniam (2019). Chapter 7
 */


/**************************************************************************
 * object (Singleton)
 *
 * El patrón singleton permite crear clases que garanticen que, de estar instanciadas, siempre se devuelve el mismo
 * objeto. Es un modo de garantizar que una clase solo tiene un único objeto.
 * En Kotlin esto se simplifica, permitiendo crearse directamente objetos sin necesidad de que sean una instancia
 * de una clase. De este modo. Estos objetos son equivalentes a un patrón singleton de Java */

object objeto1


/**************************************************************************
 * Clases
 * Kotlin simplifica la creación de clases que en Java se considera que cuenta con demasiado código repetitivo
 * (boilerplate code). La gran cantidad de código que los IDEs generan automáticamente (constructores, getters, setters...)
 * se mueve del IDE al compilador. */


class ClaseMinima


public class Coche1 {
    public val yearOfMake: Int = 0  // propiedad inmutable

    public constructor(yearOfMake: Int)

}

public class Car public constructor(public val yearOfMake: Int)


/** Clase con una propiedad */
class Coche(val anho: Int)
/* Con esta notación estamos definiendo la clase Coche, con una propiedad "anho" de solo lectura (no es modificable por
ser declarada como "val". Al mismo tiempo estamos definiendo su constructor, que recibe como argumento esa propiedad.
La línea que define la clase en realidad está definiendo el constructor principal */



fun testClases() {
    val coche = Coche(2021)  // Instancia de la clase coche llamando a su constructor principal
    println(coche.anho)  // Acceso a la variable a través de getter implícito?


    class Coche3(val anhoFabricacion: Int, var color: String)

    val coche3 = Coche3(2021, "Rojo")
    coche3.color = "Verde" // Llamada implícita al setter
    println(coche3.color) // Llamada implícita al getter


}




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



class Persona1(private val nombre: String) {
    var nombre = nombre
        set(value) {  // Definición del setter
            if (value.isBlank()) // isBlank comprueba que un String no conste solo de espacios o esté vacío
                throw RuntimeException("El nombre de una persona no puede estar vacío")
            field = value
        }

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
    var _saludo4: String = ""
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















class Rectangulo2(private val longitud: Int, private val anchura: Int) {
    private val area get() = this.longitud * this.anchura
    /* Cada vez que se accede a la propiedad, se está llamando a su getter.
    No es necesario el tipo al ser inferible por el getter */

    override fun toString() = "Rectángulo con ${area}px de área ($longitud*$anchura)"
}

fun testRentangulo() {
    println(Rectangulo2(3, 4))
}




class Persona(private val nombre: String, var edad: Int?) {

    fun presentacion() {
        println("$nombre tiene $edad años")
    }

}

data class PersonaData(
    val nombre: String,
    var edad: Int?
)

class Persona2(private var data: PersonaData) {

    override fun toString(): String {
        data.edad?.let { return "${data.nombre} tiene ${data.edad} años" }
            ?: run { return "${data.nombre} no tiene edad registrada" }

    }
}

fun pruebasPersona() {
    val persona1 = Persona("Alejandro Vidal", 35)
    persona1.presentacion()
    persona1.edad = 36
    persona1.presentacion()


    val persona2Data = PersonaData("María", 29)
    val persona2 = Persona2(persona2Data)
    println(persona2.toString())
    persona2Data.edad = 30
    println(persona2.toString())
    persona2Data.edad = null
    println(persona2.toString())

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

    override fun toString() = "Rectangulo con longitud = $longitud y anchura = $anchura"

}

fun comparaRectangulos() {
    var obj1 = Rectangulo(5, 5)
    var obj2 = Rectangulo(4, 4)

    // Comprobamos si el rectangulo 1 es mayor que el rectangulo 2
    println("${obj1 > obj2}")

}


/**************************************************************************
 * Objetos anónimos
 *
 * https://kotlinlang.org/docs/object-declarations.html
 * */

fun objetosAnonimos() {

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
 * a una interface funcional de Java, es simplificable a una lambda */

val aRunnable2 = Runnable { println("Esto se ejecutará en otro hilo") }

fun llamaRunnables() {
    aRunnable.run()
    aRunnable2.run()
}