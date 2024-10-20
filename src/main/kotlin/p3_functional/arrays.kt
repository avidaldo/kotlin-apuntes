// Arrays en kotlin

fun fun main(args: Array<String>) {
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune") // Podemos omitir el tipo de dato si el compilador puede inferirlo

    println(rockPlanets[0]) // Mercury
    println(gasPlanets[0]) // Jupiter

    val solarSystem = rockPlanets + gasPlanets // Concatenamos los dos arrays
    println(solarSystem[0]) // Mercury
    solarSystem[3] = "Little Earth"
    println(solarSystem[3]) // Little Earth

    /**
    Si deseas hacer que un array sea más grande de lo que ya es, debes crear uno nuevo. 
    Define una variable nueva llamada newSolarSystem, como se muestra. 
    Este array puede almacenar nueve elementos, en lugar de ocho.
     */

    val newSolarSystem = solarSystem + arrayOf("Pluto", "Ceres", "Eris")

    println(newSolarSystem[8]) // Eris
}