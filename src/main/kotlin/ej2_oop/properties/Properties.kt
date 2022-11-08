package ej2_oop.extra_mutable_field_visibility

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
