/**
 * https://www.geeksforgeeks.org/kotlin-higher-order-functions
 */

/* higher-order function accepting lambda as parameter */
fun higherfunc( lmbd: () -> Unit ) {
    lmbd()                               //invokes lambda expression
}

fun higherfunc2( operacion: (Int, Int) -> Int) {      // accepting lambda as parameter
    val a = 2
    val b = 4
     // invokes the lambda expression by passing parameters
    println("La operación de los dos números es: ${operacion(a,b)}")
}

fun higherfunc3(str : String, myfunc: (String) -> Unit){
    // invoke regular function using local name
    myfunc(str)
}
fun higherfunc4(a: Int, b: Int, operacion: (Int, Int) -> Int): Int{
    return operacion(a,b)
}

fun add(a: Int, b: Int) = a + b

fun main() {
    higherfunc { println("Hola") }
    higherfunc2 { a, b -> a + b }
    higherfunc2 { a, b -> a - b }
    higherfunc3("Hola", ::println)
    higherfunc3("Hola 2") { println() }
    higherfunc4(3,4, {a,b -> a+b})
    higherfunc4(3,4, ::add)



}