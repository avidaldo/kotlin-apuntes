import kotlin.random.Random

/***************************************************************************
 ** Scope functions  **********************************
 **************************************************************************
 *
 * https://kotlinlang.org/docs/scope-functions.html
 * Venkat Subramaniam (2019). Programming Kotlin. Chapter 12
 *
 *
 * Las funciones de ámbito (scope) buscan simplemente mejorar la legibilidad del código
 * 
 * https://hackernoon.com/hn-images/1*bD7r_xcW5CWN389WEfgPDg.png
 * https://hackernoon.com/kotlin-a-deeper-look-8569d4da36f
 *
 */

private class PersonaSF(val nombre: String, var edad: Int) {
    fun incrementaEdad() {
        edad++
    }

    override fun toString(): String {
        return "$nombre, $edad años"
    }
}

/** "let" permitirá ejecutar una lambda aplicada a un objeto */

fun testScopeFunctions() {
// Código al estilo Java
    val alice = PersonaSF("Alice", 20) // Necesitamos una variable para el objeto
    println(alice) // Utilizamos esa variable
    alice.incrementaEdad()
    println(alice)

/* Código creando un ámbito temporal con let. Nos evita crear una variable para
operar con el objeto y llamarla repetidamente. */
    val bob = PersonaSF("Bob", 20).let {
        println(it)
        it.incrementaEdad()
        println("$it")
    }
    println(bob)




    val listadoPersonas = mutableListOf<PersonaSF>()

    println(listadoPersonas)
    
    PersonaSF("Bob", 20).also {
        it.incrementaEdad()
        listadoPersonas.add(it)
        println(it)
    }
    
    PersonaSF("Alice", 24).also {
        it.incrementaEdad()
        listadoPersonas.add(it)
        println(it)
    }

    println(listadoPersonas)

}


class Mailer {
    val details = StringBuilder()
    fun from(addr: String) = details.append("from $addr...\n")
    fun to(addr: String) = details.append("to $addr...\n")
    fun subject(line: String) = details.append("subject $line...\n")
    fun body(message: String) = details.append("body $message...\n")
    fun send() = "...sending...\n$details"
}


fun testScopeFunctions2() {

    /** Estilo Java (verbose) */

    val mailer = Mailer()
    mailer.from("builder@agiledeveloper.com")
    mailer.to("venkats@agiledeveloper.com")
    mailer.subject("Your code sucks")
    mailer.body("...details...")
    val result = mailer.send()
    println("result1:\n$result")


    /** Eliminando referencias repetitivas con apply
     * Ejecuta la lambda en el contexto del objeto que la llama y devuelve el propio objeto,
     * de modo que podrían seguirse haciendo referencias al propio objeto. */

    val mailer2 =
        Mailer()
            .apply { from("builder@agiledeveloper.com") }
            .apply { to("venkats@agiledeveloper.com") }
            .apply { subject("Your code sucks") }
            .apply { body("details") }
    val result2 = mailer2.send()
    println("result2:\n$result2")


    /** run devuelve el resultado de la última expresión de la lambda (el String del método send()
     * */

    val result3 = Mailer().run {
        from("builder@agiledeveloper.com")
        to("venkats@agiledeveloper.com")
        subject("Your code sucks")
        body("details")
        send()
    }
    println("result3:\n$result3")

}

fun testScopeFunctions3let() {
    val empty = "test".let { // Ejecuta el bloque sobre el resultado del objeto "test"
        it.isEmpty()     // let devuelve el valor de esta expresión
    }
    println("Is empty: $empty")


    fun printNonNull(str: String?) {
        print("Printing \"$str\":")

        str?.let {  // Usamos safe call, así que el bloque solo se ejecuta si str no es null
            print(it)
        }
        println()
    }
    printNonNull(null)
    printNonNull("my string")

    fun printIfBothNonNull(strOne: String?, strTwo: String?) {
        strOne?.let { firstString ->
            /* Usamos nombre personalizado para que el let anidado pueda acceder al let externo */
            strTwo?.let {
                println("$firstString : $it")
                println()
            }
        }
    }

    printIfBothNonNull("First", null)
    printIfBothNonNull("First", "Second")


}



fun testScopeFunctions3also() {
    fun getRandomInt(): Int {
        return Random.nextInt(100).also {
            println("getRandomInt() generated value $it")
        }
    }

    val i = getRandomInt()
    println(i)

}


fun testScopeFunctions4let() {

    val numbers = mutableListOf("one", "two", "three", "four", "five")

    /** Aplicamos sobre una coleccion operaciones:
     * map: para cada elemento aplica la lamda (se convierte el elemento en su longitud)
     * filter: se eliminan los elementos que no cumplan la condición
     */
    val resultList = numbers.map { it.length }.filter { it > 3 }
    println(resultList)


    println(mutableListOf("one", "two", "three", "four", "five").run{ filter { it.length > 3 }})


    /** let permitirá printear el resultado de la operación y hacer más cosas sobre la
     * referencia al objeto desde que se llama (it) */
    numbers.map { it.length }.filter { it > 3 }.let {
        println(it)
        // otras llamadas si fuesen necesariass
    }

    /** si se pasa solo una función se puede usar la referencia al método en lugar de la lambda */
    numbers.map { it.length }.filter { it > 3 }.let(::println)

}



fun testScopeFunctions4with() {

    /** with no es una función de extensión (a diferencia de las otras funciones de ámbito)
     * El objeto contexto se pasa como argumento, pero dentro de la lambda, estará disponible
     * como un receiver (this). Devuelve el resultado de la lambda.
     */

    val numbers = mutableListOf("one", "two", "three")
    with(numbers) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }

    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)

}


fun testScopeFunctions4also() {
    val numbers = mutableListOf("one", "two", "three")

    numbers.let{ println("The list elements before adding new one: $it") }

    /** also permite acceder al objeto contexto como let (con it), pero además devuelve el objeto.
     */

    numbers
        .also { println("The list elements before adding new one: $it") }
        .add("four")
}


fun main() {
    testScopeFunctions(); println("\n----\n")
    testScopeFunctions2(); println("\n----\n")
    testScopeFunctions3let(); println("\n----\n")
    //testScopeFunctions3run(); println("\n----\n")
    testScopeFunctions3also(); println("\n----\n")
    testScopeFunctions4let(); println("\n----\n")
    testScopeFunctions4with(); println("\n----\n")
    testScopeFunctions4also(); println("\n----\n")
}