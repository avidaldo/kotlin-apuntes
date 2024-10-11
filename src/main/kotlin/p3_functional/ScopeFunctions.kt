/**
 * Scope Functions o funciones de ámbito.
 * 
 * Las Scope Functions son "run", "apply", "also" y "let"
 * 
 * Empezaremos con "let"
 */

// let sirve para ejecutar un bloque de código si el objeto sobre el cuál se está ejecutando dicho objeto no es nulo

fun pruebaLet() {
    val numeros = listOf(1,2,3,4)
    
    for (n in numeros) {
        /* Vamos a usar takeIf, una función la cuál sirve para que si la condición se cumple devuelve un objeto
         * si la condición no se cumple devuelve un nulo */
        n.takeIf {it < 3}?.let {
            println("El valor es $n")
        }
        
        /**
         * Como podemos observar en la salida, los únicos valores que cumplen la condición del takeIf son los menores a 3
         * por lo que los mayores devuelven nulo y por lo tanto, no ejecutan el scope del let */
    }
}

/**
 * run nos sirve para acceder a las propiedades de un objeto
 */
 
// Declararemos una data class perro que tiene una propiedad nombre y otra raza
data class Perro(var name: String, var edad: Int)
 
fun pruebaRun() {
    val perro = Perro("Toby",3)
    println("Antes del run ${perro.toString()}")
    // Podemos utilizar run para no estar escribiendo perro.edad por ejemplo y acceder a la propiedad más rápido
    perro.run { // Aquí podriamos modificar todo lo que quisieramos, dentro de este Scope
        edad++ 
    }
    println("Después del run ${perro.toString()}")
    
    val mensaje = perro.run {
        edad++
        "La edad es $edad"
    }
    println("run me ha devuelto el siguiente mensaje: $mensaje")
}

/**
 * La función apply también nos sirve para acceder a las propiedades de un objeto y modificarlas
 * la diferencia principal está en que un scope apply nos devuelve el mismo objeto que abre el scope */

fun pruebaApply() {
    val perro = Perro("Toby",3)
	val otroPerro = perro.apply {
        name = "Toby modificado"
        this.edad = 5 // No es necesario el this pero también funciona
    }
   	println("El perro inicial ${perro.toString()}")
    println("El otro perro tras el apply ${otroPerro.toString()}")
    
    // Sin embargo si hiciera lo mismo con run
    val otroPerroRun = perro.run {
        name = "Toby modificado en el run"
        this.edad = 5 // No es necesario el this pero también funciona
    }
    println("El perro inicial ${perro.toString()}")
    println("El otro perro pero con run ${otroPerroRun.toString()}")
    /**
     * Es importante ver como todos los cambios de dentro de ambos scope han afectado al perro original
     * pero la diferencia está en que apply nos devuelve el mismo objeto a la val "otroPerro" pero
     * sin embargo al hacer lo mismo con run nos ha devuelto Unit, ya que devuelve lo que pongamos en la 
     * última línea, que en este caso es Unit ya que solo hemos hecho una llamada a un setter que no 
     * devuelve nada */
}

/**
 * La función also es muy similar a apply solo que se suele usar para registrar logs de eventos además de devolver
 * el propio objeto y/o modificarlo, solo que en este scope modificaremos el objeto usando it */

fun pruebaAlso() {
    val perro = Perro("Toby", 3)
    val perroAlso = perro.also {
        it.name = "Toby en el also"
        // edad =  5 esto falla en compilación
        it.edad = 5 // así bien
        println("Logs y eventos a registrar se puede hacer aquí en este bloque, pero no devuelve esto, si no el objeto")
    }
    println(perro)
    println(perroAlso)
}

fun main() {
    println("Prueba LET")
    pruebaLet()
    println("---------------")
    println("Prueba RUN")
    pruebaRun()
    println("---------------")
    println("Prueba APPLY")
    pruebaApply()
    println("---------------")
    println("Prueba ALSO")
    pruebaAlso()
}
