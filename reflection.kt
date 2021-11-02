
/* Para probar código online: https://play.kotlinlang.org/  */


/***************************************************************************
 ** Reflection **********************************
 **************************************************************************
 * 
 * https://kotlinlang.org/docs/reflection.html
 */

 /* Podemos ver el tipo de variable en tiempo de ejecución mediante reflexión */

fun main() {

   val hola = "hola mundo"
   println(hola)
   println(hola::class) // Reflection de Kotlin
   println(hola::class.java) // Reflection de Java
   println(hola.javaClass)

}


/* La llamada "::class" devuelve la clase de Kotlin del objeto referenciado.
la llamada ".javaClass" devuelve la clase java subyacente (no olviemos que estamos
compilando Kotlin a bytecode para ser ejecutado en la JDK) */



/* En Android Studio, para poder utilizar la reflection de Kotlin, será necesario incorporar la 
al build.gradle del módulo la dependencia:

dependencies {
   // ...

   implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
}

Sin embargo, ya que Android compila a Bytecode Java, se utilizará la reflection de Java 
*/