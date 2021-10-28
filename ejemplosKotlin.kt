
/*
Fuentes:
https://openwebinars.net/academia/aprende/kotlin-para-android
https://play.kotlinlang.org/byExample/overview
Programming Kotlin by Venkat Subramaniam (2019). Chapters 2 & 3

Para probar código online: https://play.kotlinlang.org/
*/



// Función main






//

fun main() {

    // Utilizaremos "var" para variables mutables
    var variable1: Int
    variable1 = 3
    variable1 = 4
    variable1 = null


// Int?


    var variable2 = "hola" // Kotlin permite (y recomienda) la inferencia de tipos
    variable2 = "adios"
    variable2 = null




    println(variable1)


    // Utilizaremos val para variables inmutables (final)

    val greet = "hello"
    println(greet)
    println(greet::class)
    println(greet.javaClass)



    // const se utilizará para variables que son conocidas en tiempo de ejecución (static)
    const val KEY_COSA = "cosa"






}



fun simplestFunction() = "hola"

// Función básica

 private fun funcion1(): Unit { // Unit equivale a void en Java




        // Podemos ver el tipo de variable en tiempo de ejecución mediante reflexión:
        println(variable1::class.toString()) // https://kotlinlang.org/docs/reflection.html#jvm-dependency
        println(variable1::class)
        println(variable1.javaClass.toString())


        // Pero en tiempo de compilación, podemos comprobar que la inferencia de tipos funciona correctamente:
        //variable1 = 1

        // En caso de no inicializar, no se puede utilizar la inferencia de tipos:
        var variable2: Int
        variable2 = 3


        // Declaración de una variable final
        val constante1 = "contante"
        //constante1 = "const2"


        val pi = 3.14
        println(pi::class.toString())


        val message = StringBuilder("hello ")
        //message = StringBuilder("another") //ERROR  // Inmutabilidad de referencia
        message.append("there") // no de objeto

    }








// Equality

println("hi" == "hi")
println("hi" == "Hi")
println(null == "hi")
println("hi" == null)
println(null == null)



// Type inference



fun main(args: Array<String>) {
    val greet = "hello"
    println(greet)
    println(greet::class)
    println(greet.javaClass)
}


// Definir argumentos

fun greet(name: String): String = "Hello $name"
println(greet("Eve")) //Hello Eve