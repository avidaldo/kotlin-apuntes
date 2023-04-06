//
// Rangos basándose en objeto ej2_oop.Rectangulo: https://www.geeksforgeeks.org/comparable-interface-in-kotlin/



fun main(){
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    val resultList = numbers.map{ it.length }.filter{ it > 3 }
    println(resultList)

}