/**
* Ejemplo de uso de genéricos: 
* Fuentes: 
* - Codelab sobre genéricos, objetos y extensiones: https://developer.android.com/codelabs/basic-android-kotlin-compose-generics?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-3-pathway-1%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-generics#1
* - Documentación oficial: https://kotlinlang.org/docs/generics.html
*/
​
/**
* Imaginad que queremos representar preguntas de un formulario y tenemos tres tipos de posibles respuestas:
* - Respuesta de texto
* - De verdadero o falso
* - Respuesta con un valor numérico
* De cada pregunta nos interesa pues almacenar el texto de la pregunta, el texto de la respuesta (primer caso), un valor booleano (segundo caso) o 
* un valor numérico (tercer caso). Junto con un valor para la dificultad de la pregunta que puede ser "fácil", "medio" o "difícil".
* Para esto podriamos generar tres clases como las siguientes:
*/
​
class FillInTheBlankQuestion(
    val questionText: String,
    val answer: String,
    val difficulty: String
)
​
class TrueOrFalseQuestion(
    val questionText: String,
    val answer: Boolean,
    val difficulty: String
)
​
class NumericQuestion(
    val questionText: String,
    val answer: Int,
    val difficulty: String
)
​
/**
 * Cómo se puede observar, el código anterior es muy repetitivo. Sin embargo, las tres clases tienen las mismas propiedades.
 *  
 * Tan solo cambia el tipo de la propiedad answer. Podriamos pensar que la solución pasa por crear una superclase y hacer que 
 * cada subclase defina la propiedad answer, pero, esta solución no evitaría que cada vez que quisieramos un nuevo tipo de 
 * pregunta haya que crear una nueva subclase para este nuevo tipo de pregunta y, por otro lado, es un poco raro una superclase
 * Qyestion sin propiedad answer. 
 * 
 * Para solucionar esta situación podemos hacer uso de los tipos genéricos, de forma que denamos una única clase Question
 * con su propiedad answer de tipo genérico, que nos sirva para cualquier tipo de respuesta. Este tipo genérico se define de 
 * la siguiente forma:
 * 
 * class ClassName <generic data type> (properties)
 * 
 * De esta forma, cuándo se crea una instancia de la clase, se proporciona un tipo de datos genérico, por lo que debe definirse
 * como parte de la firma de la clase. 
 * 
 * Para dentro de la definición de la clase declarar cuál o cuáles van a ser las propiedades que reciban los tipos genéricos 
 * al instanciarse podemos utilizar la misma sintaxis:
 * 
 * class ClassName <generic data type> (
 *      val propertyName : generic data type
 * )
 * 
 * Sabremos entonces qué tipo de datos usar al pasar como parámetro entre los corchetes angulares el tipo de dato en el momento
 * de la instanciación de la clase:
 * 
 * val instanceName = ClassName<generic data type>( parameters )
 * 
 * !!! Ojo: Los genéricos que se pasan al crear una instancia también son parámetros, aunque son parte de una lista de parámetros 
 * independiente de los valores de propiedades ubicados entre paréntesis. También es habitual verlos denominados con letras mayúsculas
 * como <T> (abreviando tipo) o cualquier otra letra, no existe una regla para usar una letra o nombres más descriptivos. 
 * 
 * Refactoricemos ahora las tres clases anteriores creando una única clase "Question" con genéricos:
 * 
 */
 
 class Question<T>(
    val questionText: String,
    val answer: T, // Este es el tipo genérico definido para esta propiedad que se decide al instanciar de qué tipo es
    val difficulty: String
)
​
fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium") // Así quedaría nuestra pregunta de respuesta normal
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy") // Así la de verdadero o falso
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard") // Y así la numérica
}
