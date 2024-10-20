/*
Un Map es una colección que consta de claves y valores. 
Se llama un mapa porque las claves únicas se asignan a otros valores. 

Los mapas se pueden declarar con las funciones mapOf() o mutableMapOf(). 
Los mapas requieren dos tipos genéricos separados por comas: uno para las claves y otro para los valores.
 */

fun main () {
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystem.size) // 8
    solarSystem.put("Pluto", 5) // Agregamos un nuevo planeta
    println(solarSystem.size) // 9
    println(solarSystem["Pluto"]) // 5

    println(solarSystem.get("Theia")) // null

    solarSystem.remove("Pluto") // Eliminamos un planeta
    println(solarSystem.size) // 8

    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"]) // 78

}