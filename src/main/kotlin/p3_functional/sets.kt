/**
El beneficio de los conjuntos es garantizar la singularidad. 
Si estuvieras escribiendo un programa para hacer un seguimiento de los planetas recién descubiertos, 
un conjunto ofrecería una manera simple de comprobar si un planeta ya fue descubierto. 
Cuando hay grandes cantidades de datos, esto suele ser preferible a verificar si un elemento 
existe en una lista, lo que requiere la iteración de todos los elementos.

Al igual que List y MutableList, hay un Set y un MutableSet. 
MutableSet implementa Set, por lo que cualquier clase que implemente MutableSet debe usar ambos elementos.
 */

fun main(args: Array<String>) {
    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size) // 8

    solarSystem.add("Pluto") // Agregamos un nuevo planeta
    println(solarSystem.size) // 9

    println(solarSystem.contains("Pluto")) // true

}