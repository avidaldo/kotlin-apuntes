/** Para probar código online (más ligero): https://play.kotlinlang.org/  */


/***************************************************************************
 ** Funciones **********************************
 **************************************************************************
 *
 * Fuentes:
 * Programming Kotlin by Venkat Subramaniam (2019). Chapter 3
 *
 *
 * Kotlin no requiere que el elemento de primera clase (first-class citizen) sea siempre una clase, como hace Java.
 * Una característica muy criticada de lenguajes basados en clases como Java es el tener
 * que enmascarar funciones autónomas (standalone) como métodos estáticos de una clase.
 *
 * En Kotlin las funciones son objetos (first-class function). Esto significa que se puden pasar funciones como
 * argumentos a otras funciones, devolver funciones como valores para otras funciones? y asignarlas a variables.
 * Esto es una característica imprescindible para realizar programación funcional, en la que el uso de funciones
 * de orden superior (higher-order functions) es una práctica habitual.
 *
 */


fun main() {    /* Meto el código en el ej2_oop.extra.main para facilitar la ejecución.
Kotlin permite definir funciones dentro del bloque de otra función */

    /* Función con bloque de cuerpo */
    fun saludar1(nombre: String): String {
        return "Hola, $nombre" // Si devuelve un valor (relevante), requiere return
    }

    /** Las funciones en Kotlin pueden ser tratadas como expresiones */

    /** Se permiten funciones de una única expresion **/
    fun saludar2(nombre: String): String = "Hola, $nombre"

    /** En expresiones únicas se puede inferir el tipo de salida: */
    fun saludar3(nombre: String) = "Hola, $nombre"
    println(saludar3("Alejandro"))


    fun simplestFunction() = "Hola"  // no tendría mucho sentido, para esto se usaría una variable.
    println(simplestFunction())



    /******************************************************************************************
     *  Kotlin utiliza el tipo Unit para aquellas funciones que no devuelven nada relevante.
     * Puede entenderse como similar a la primitiva void de Java, pero en Kotlin siempre se devuelve
     * algo, aunque sea el objeto Unit. Unit es un singleton que no tiene información.  */

    fun funcionQueNoDevuelveNada(nombre: String): Unit = println("Hola, $nombre")

    /** Como cualquier otro tipo, también se puede inferir, así que normalmente no se especificará: */
    fun funcionQueNoDevuelveNada2(nombre: String) = println("Hola, $nombre")

    // val mensaje: String = funcionQueNoDevuelveNada2() // Error, tipos no coincidentes

    var nombre = "Alice"
    val escrituraMensaje = funcionQueNoDevuelveNada2(nombre)
    nombre = "Bob"
    println("escrituraMensaje() devuelve $escrituraMensaje") // ¡¡La variable no es un String, sino Unit!!






    /************************************************************************
     *  Los parámetros, a diferencia de Java, son siempre val */
    fun saludar4(nombre: String): String {
        // nombre = nombre.uppercase() // Error de compilación. No se puede reasignar una variable val
        return "Hola, $nombre"
    }
    println("saludar4: ${saludar4("Alejandro")}")


    /** Utilizamos = para asignar directamente a una expresión, y los bloques ({}) para comportamientos que
     * requieran utilizar varias sentencias, y entonces utilizamos return. No se deben combinar ambas formas */

    fun prueba1() = 2; // La función infiere el tipo de salida Int y lo devuelve
    println("prueba1 devuelve \"${prueba1()}\" tras inferir que su tipo es ${prueba1()::class}")

    fun liada1() = { 2 } /* Esta función entiende que el bloque es una lambda  */
    println("liada1 devuelve \"${liada1()}\" tras inferir que su tipo es ${liada1()::class}")

    fun liada1b(): () -> Int = { 2 } // Variante explicitando el tipo que se devuelve (una lambda que devuelve un Int)
    println("liada1 devuelve \"${liada1b()}\" tras inferir que su tipo es ${liada1b()::class}")

    fun liada1c() = { -> 2 } /* Variante explicitando la lambda  */
    println("liada1 devuelve \"${liada1c()}\" tras inferir que su tipo es ${liada1c()::class}")

    fun prueba2(): Int {
        return 2
    } /* Así vuelve a ser correcto (bloque con return, coherente con el tipo esperado */
    println("prueba2 devuelve \"${prueba2()}\" tras inferir que su tipo es ${prueba2()::class}")





    /***********************************************************
     * Default arguments *************************************
     *
     * Aunque se pueden sobrecargar funciones, al igual que en Java, Kotlin también permite
     * asignar valores por defecto a argumentos (como en PHP) */

    fun saludo(nombre: String, saludo: String = "Hola") = println("$saludo, $nombre")
    saludo("Alejandro", "Buenos días")
    saludo("Alejandro")

    /* Los argumentos con valores por defecto serán normalmente los últimos, ya que en caso contrario
    * podría no quedar claro qué argumentos son los que se están pasando */
    fun fun1(a: Int, b: Int = 6, c: Int = 5) = a + b + c
    fun1(2, 3);
    fun fun2(a: Int = 1, b: Int = 6, c: Int) = a + b + c
    // fun2( 2, 3) // Error. se asume que se están pasando los argumentos a y b; y c no tiene valor por defecto

    /* Pero podrían utilizarse con argumentos nombrados (named arguments): */
    fun2(b=2, c=3)





    /***********************************************************
     * Número variable de argumentos **************************************/

    /** Función que devuelve el máximo de un listado de números recibiendo un número variable de parámetros en lugar
     * de un array o una lista */
    fun max(vararg numbers: Int): Int {
        var max = Int.MIN_VALUE // Constante con el valor mínimo de un Int
        for (number in numbers) {
            max = if (number > max) number else max
        }
        return max
    } /* Realmente esta función tiene un problema: si no se pasa ningún parámetro, devuelve la contante MIN_VALUE,
    sea o no un valor de la lista de parámetros */
    println("max(): ${max()}; max(3, 6, 2): ${max(3, 6, 2)}")


    /* La misma función, más correcta: */
    fun maxOrNull(vararg numbers: Int): Int? { /* Definimos la salida como nullable, ya que si no se pasan parámetros
        se devolverá null */
        if (numbers.isEmpty()) return null
        var max = numbers[0]
        for (num in numbers) {
            max = if (max < num) max else num
        }
        return max
    }

    /* Podría simplificarse a esto: */
    fun maxOrNull2(vararg numbers: Int) = numbers.maxOrNull()







}
